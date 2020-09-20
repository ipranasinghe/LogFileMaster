package lk.slt.soa.logfilesmaster.service;

import lk.slt.soa.logfilesmaster.models.LogError;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LogFileService {

    private List<LogError> logErrors = new ArrayList<>();

    public List<LogError> GetAllLogErrors(){
//        read log file
//        add log errors
//        return log errors
        return this.logErrors;
    }
//    Get all errors
//    REad log file
//    create all logerrorss
}
