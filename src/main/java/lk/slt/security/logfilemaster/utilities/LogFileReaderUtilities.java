package lk.slt.security.logfilemaster.utilities;

import lk.slt.security.logfilemaster.model.ErrorEntity;

public class LogFileReaderUtilities {

    public String getOrderID(String payLoad) {
        try {
            return payLoad.split(" - ")[1];
        }
        catch (ArrayIndexOutOfBoundsException e){
            return "Order Id not found";
        }
    }

    public String getOrderNumber(String payLoad) {
        try {
            return payLoad.split("<xci0:OrderNumber>")[1].split("</xci0:OrderNumber>")[0];
        }
        catch (ArrayIndexOutOfBoundsException e){
            return "Order Number not found";
        }
    }

    public String getErrorDescription(String payLoad) {
        try {
            return payLoad.split(" Message: ")[0];
        }
        catch (ArrayIndexOutOfBoundsException e){
            return "Error Description not found";
        }
    }

    public ErrorEntity createEntityData(String payLoad, int id) {
        ErrorEntity error = new ErrorEntity();

        error.setId(id);
        error.setPayloadID(getOrderID(payLoad));
        error.setOrderNumber(getOrderNumber(payLoad));
        error.setErrorDescription(getErrorDescription(payLoad));

        return error;
    }

    public static boolean IsError(String payLoad) {
        if (payLoad.contains("[ERROR]")) {
            return true;
        }
        return false;
    }
}
