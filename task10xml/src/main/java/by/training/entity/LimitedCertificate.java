package by.training.entity;

import java.util.Date;

public class LimitedCertificate extends Certificate {
    private Date expirationDate;

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
}
