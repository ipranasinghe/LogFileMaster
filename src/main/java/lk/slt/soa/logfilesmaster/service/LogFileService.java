package lk.slt.soa.logfilesmaster.service;

import lk.slt.soa.logfilesmaster.models.LogError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.core.io.Resource;

import java.io.ByteArrayInputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Service
public class LogFileService {

    @Autowired
    private LogErrorService logErrorService;
    @Autowired
    private  FileSystemStorageService fileSystemStorageService;

    private List<LogError> logErrors = new ArrayList<>();

    public List<LogError> GetAllLogErrors(){
        Resource file = getLogFile();
        logErrors = logErrorService.getAllLogErrors(file);
        fileSystemStorageService.deleteAll();
        return logErrors;
    }

    public Resource getLogFile() {
        Path path = fileSystemStorageService.loadAll().findFirst().get();
        String fileName = path.getFileName().toString();
        Resource file = fileSystemStorageService.loadAsResource(fileName);

        return file;
    }

}
