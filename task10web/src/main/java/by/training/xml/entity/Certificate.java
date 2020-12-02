package by.training.xml.entity;

import java.util.Date;

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
}
