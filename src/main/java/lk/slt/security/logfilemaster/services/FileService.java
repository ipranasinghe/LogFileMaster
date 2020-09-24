package lk.slt.security.logfilemaster.services;

import lk.slt.security.logfilemaster.model.ErrorEntity;

import java.util.List;

public interface FileService {
    List<ErrorEntity> getProcessedErrors();
    public void readLogFile();

}
