package lk.slt.security.logfilemaster.repository;

import lk.slt.security.logfilemaster.model.ErrorEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LogFileErrorRepository {

    private static final List<ErrorEntity> DB = new ArrayList<>();

    public int insertError(ErrorEntity error) {
        DB.add(error);
        return error.getId();
    }

    public List<ErrorEntity> getAllErrors() {
        return DB;
    }
}
