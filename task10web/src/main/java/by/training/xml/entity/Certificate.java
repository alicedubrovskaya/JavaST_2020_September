package by.training.xml.entity;

import java.util.Date;
import java.util.Objects;

public class Certificate {
    private String number;
    private Date issueDate;
    private String organization;

    public void setNumber(String number) {
        this.number = number;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getNumber() {
        return number;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public String getOrganization() {
        return organization;
    }

    //TODO hashcode, equals
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Certificate certificate = (Certificate) o;
        return Objects.equals(number, certificate.number)
                && Objects.equals(issueDate, certificate.issueDate)
                && Objects.equals(organization, certificate.organization);
    }
}
