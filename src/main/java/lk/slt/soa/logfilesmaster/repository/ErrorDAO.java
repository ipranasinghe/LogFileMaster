package lk.slt.soa.logfilesmaster.repository;

import lk.slt.soa.logfilesmaster.models.LogError;

import java.util.List;

public interface ErrorDAO {

    int insertLogData(LogError logError);

    int insertLogData(int ID, String payloadID, String orderNumber, String errorDescription);

    default int insertLogData(String payloadID, String orderNumber, String errorDescription){
        int id = (int) Math.random();
        return insertLogData(id, payloadID, orderNumber, errorDescription);
    }

    List<LogError> selectAllLogData();

}
