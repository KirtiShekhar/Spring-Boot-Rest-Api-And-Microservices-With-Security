package com.springboot.bankingsecurity.service;

import com.springboot.bankingsecurity.dto.NoticeRequestDto;
import com.springboot.bankingsecurity.entity.Notice;

import java.util.List;

public interface NoticeService
{
    Notice saveNotice(NoticeRequestDto noticeRequestDto);
    Notice getNoticeById(Long noticeId);
    List<Notice> getNotices();
    List<Notice> getActiveNotices();
}
