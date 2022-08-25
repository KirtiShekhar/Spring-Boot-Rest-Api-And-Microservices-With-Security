package com.springboot.bankingsecurity.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Notice")
public class Notice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "noticeId")
	private Long noticeId;

	@Column(name = "noticeSummary")
	private String noticeSummary;

	@Column(name = "noticeDetails")
	private String noticeDetails;

	@Column(name = "noticeBegDt")
	private String noticeBegDt;
	
	@Column(name = "noticeEndDt")
	private String noticeEndDt;
	
	@Column(name = "createDt")
	private String createDt;
	
	@Column(name = "updateDt")
	private String updateDt;

	public Notice() {}

	public Notice(Long noticeId, String noticeSummary, String noticeDetails, String noticeBegDt, String noticeEndDt, String createDt, String updateDt) {
		this.noticeId = noticeId;
		this.noticeSummary = noticeSummary;
		this.noticeDetails = noticeDetails;
		this.noticeBegDt = noticeBegDt;
		this.noticeEndDt = noticeEndDt;
		this.createDt = createDt;
		this.updateDt = updateDt;
	}

	public Long getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(Long noticeId) {
		this.noticeId = noticeId;
	}

	public String getNoticeSummary() {
		return noticeSummary;
	}

	public void setNoticeSummary(String noticeSummary) {
		this.noticeSummary = noticeSummary;
	}

	public String getNoticeDetails() {
		return noticeDetails;
	}

	public void setNoticeDetails(String noticeDetails) {
		this.noticeDetails = noticeDetails;
	}

	public String getNoticeBegDt() {
		return noticeBegDt;
	}

	public void setNoticeBegDt(String noticeBegDt) {
		this.noticeBegDt = noticeBegDt;
	}

	public String getNoticeEndDt() {
		return noticeEndDt;
	}

	public void setNoticeEndDt(String noticeEndDt) {
		this.noticeEndDt = noticeEndDt;
	}

	public String getCreateDt() {
		return createDt;
	}

	public void setCreateDt(String createDt) {
		this.createDt = createDt;
	}

	public String getUpdateDt() {
		return updateDt;
	}

	public void setUpdateDt(String updateDt) {
		this.updateDt = updateDt;
	}	
}
