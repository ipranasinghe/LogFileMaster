package lk.slt.soa.logfilesmaster.models;

public class LogError {

    private int id;

    private String payloadID;

    private String orderNumber;

    private String errorDescription;

    public void setPayloadID(String payloadID) {
        this.payloadID = payloadID;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public int getId() {
        return id;
    }

    public String getPayloadID() {
        return payloadID;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public LogError() {
        this.payloadID = payloadID;
        this.orderNumber = orderNumber;
        this.errorDescription = errorDescription;
    }

    public LogError(int id, String payloadID, String orderNumber, String errorDescription) {
    }
}
