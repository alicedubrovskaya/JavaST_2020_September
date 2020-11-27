package by.training.entity;

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
}
