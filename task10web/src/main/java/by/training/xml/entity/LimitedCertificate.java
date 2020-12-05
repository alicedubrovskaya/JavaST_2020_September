package by.training.xml.entity;

import by.training.xml.entity.list.VersionList;

import java.util.Date;
import java.util.Objects;

public class LimitedCertificate extends Certificate {
    private Date expirationDate;

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LimitedCertificate certificate = (LimitedCertificate) o;
        return Objects.equals(expirationDate, certificate.expirationDate);
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }
}
