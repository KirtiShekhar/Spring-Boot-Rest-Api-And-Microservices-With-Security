package com.springboot.bankingsecurity.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.sql.Date;

public class ContactRequestDto
{
    private String contactName;
    private String contactEmail;
    private String subject;
    private String message;
    @JsonIgnore
    private String createDt;

    public ContactRequestDto() {}

    public ContactRequestDto(String contactName, String contactEmail, String subject, String message, String createDt) {
        this.contactName = contactName;
        this.contactEmail = contactEmail;
        this.subject = subject;
        this.message = message;
        this.createDt = createDt;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCreateDt() {
        return createDt;
    }

    public void setCreateDt(String createDt) {
        this.createDt = createDt;
    }
}
