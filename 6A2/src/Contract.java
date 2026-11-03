package telecom.models;

import java.util.Date;

public class Contract {
    public String contractId;
    public String clientData;
    public Date dateSigned;

    public Contract(String contractId, String clientData) {
        this.contractId = contractId;
        this.clientData = clientData;
        this.dateSigned = new Date();
    }
}
