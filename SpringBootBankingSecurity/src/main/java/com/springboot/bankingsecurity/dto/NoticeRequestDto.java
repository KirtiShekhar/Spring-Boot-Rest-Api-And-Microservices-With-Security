package com.springboot.bankingsecurity.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Date;

public class NoticeRequestDto
{
    private String noticeSummary;
    private String noticeDetails;
    @JsonIgnore
    private String noticeBegDt;
    @JsonIgnore
    private String noticeEndDt;
    @JsonIgnore
    private String createDt;
    @JsonIgnore
    private String updateDt;

    public NoticeRequestDto() {}

    public NoticeRequestDto(String noticeSummary, String noticeDetails, String noticeBegDt, String noticeEndDt, String createDt, String updateDt) {
        this.noticeSummary = noticeSummary;
        this.noticeDetails = noticeDetails;
        this.noticeBegDt = noticeBegDt;
        this.noticeEndDt = noticeEndDt;
        this.createDt = createDt;
        this.updateDt = updateDt;
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
