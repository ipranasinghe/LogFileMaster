package lk.slt.soa.logfilesmaster.service;

import com.sun.istack.NotNull;
import lk.slt.soa.logfilesmaster.models.LogError;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class LogErrorService {

    public List<LogError> getAllLogErrors(@NotNull Resource resource){
        List<LogError> logErrors = new ArrayList<>();

        String textLine = null;

        try {
            var file = resource.getFile();
            try (BufferedReader infile = new BufferedReader(new FileReader(file))) {

                while ((textLine = infile.readLine()) != null) {

                    if (isError(textLine)) {
                        LogError error = new LogError();
                        error.setPayloadID(getPayLoadID(textLine));
                        error.setOrderNumber(getOrderNumber(textLine));
                        error.setErrorDescription(getErrorDescription(textLine));

                        logErrors.add(error);
                    }
                }
            }
        } catch (IOException io) {
//            log4j note
        }

        return logErrors;
    }

    public String getOrderNumber(String payLoad) {
        try {
            return payLoad.split("<xci0:OrderNumber>")[1].split("</xci0:OrderNumber>")[0];
        }
        catch (ArrayIndexOutOfBoundsException e){
            return "Order number not found";
        }
    }

    public String getErrorDescription(String payLoad) {
        try {
            return payLoad.split(" Message: ")[0];
        }
        catch (ArrayIndexOutOfBoundsException e){
            return "Error description not found";
        }
    }

    public String getPayLoadID(String payLoad) {
        try {
            return payLoad.split(" - ")[1];
        }
        catch (ArrayIndexOutOfBoundsException e){
            return "Payload id not found";
        }
    }

    public static boolean isError(String payLoad){
        if(payLoad.contains("[ERROR]")) {
            return true;
        }
        return false;
    }
}
