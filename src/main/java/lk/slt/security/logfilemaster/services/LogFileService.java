package lk.slt.security.logfilemaster.services;

import lk.slt.security.logfilemaster.model.ErrorEntity;
import lk.slt.security.logfilemaster.repository.LogFileErrorRepository;
import lk.slt.security.logfilemaster.utilities.LogFileReaderUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class LogFileService implements FileService{

    final LogFileErrorRepository logfileErrorRepository;

    final StorageService storageService;;
    public List<ErrorEntity> errors;

    @Autowired
    public LogFileService(LogFileErrorRepository logfileErrorRepository, StorageService storageService) {
        this.logfileErrorRepository = logfileErrorRepository;
        this.storageService = storageService;
        this.errors = Collections.emptyList();
    }

    @Override
    public List<ErrorEntity> getProcessedErrors() {
        if(this.errors.size() == 0){
            readLogFile();
        }
        this.errors = logfileErrorRepository.getAllErrors();
        return  this.errors;
    }

    @Override
    public void readLogFile() {

        LogFileReaderUtilities logFileReaderUtilities = new LogFileReaderUtilities();

        Optional<Path> filePath = storageService.loadAll().findFirst();

        if(filePath.isEmpty()){
            return;
        }

        String name = filePath.get().getFileName().toString();
        File file =  storageService.load(name).toFile();

        String textLine = null;
        int errorId = 0;

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file)))
        {
            while ((textLine = bufferedReader.readLine()) != null) {

                if(LogFileReaderUtilities.IsError(textLine)){
                    ErrorEntity error = logFileReaderUtilities.createEntityData(textLine, errorId++);
                    logfileErrorRepository.insertError(error);
                }
            }
        }
        catch (FileNotFoundException fileNotFoundException)
        {
            //out.println("The file \""+log+"\" was not found");
        }
        catch (IOException ioException)
        {
            //out.println("Error reading the file");
        }

        storageService.deleteAll();
    }
}
