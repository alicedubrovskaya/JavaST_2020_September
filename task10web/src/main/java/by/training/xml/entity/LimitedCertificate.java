package by.training.xml.entity;

import java.util.Date;

public class LimitedCertificate extends Certificate {
    private Date expirationDate;

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }
}
