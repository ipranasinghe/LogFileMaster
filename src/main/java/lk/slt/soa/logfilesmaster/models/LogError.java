package lk.slt.soa.logfilesmaster.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class LogError {
    private int id;

    private String payloadID;

    private String orderNumber;

    private String errorDescription;
}
