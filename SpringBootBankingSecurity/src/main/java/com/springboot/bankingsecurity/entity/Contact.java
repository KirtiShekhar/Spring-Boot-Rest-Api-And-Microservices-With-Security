package com.springboot.bankingsecurity.entity;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "Contact")
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "contactId")
	private Long contactId;

	@Column(name = "contactName")
	private String contactName;

	@Column(name = "contactEmail")
	private String contactEmail;

	@Column(name = "subject")
	private String subject;

	@Column(name = "message")
	private String message;

	@Column(name = "createDt")
	private String createDt;

	public Contact() {}

	public Contact(Long contactId, String contactName, String contactEmail, String subject, String message, String createDt) {
		this.contactId = contactId;
		this.contactName = contactName;
		this.contactEmail = contactEmail;
		this.subject = subject;
		this.message = message;
		this.createDt = createDt;
	}

	public Long getContactId() {
		return contactId;
	}

	public void setContactId(Long contactId) {
		this.contactId = contactId;
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
