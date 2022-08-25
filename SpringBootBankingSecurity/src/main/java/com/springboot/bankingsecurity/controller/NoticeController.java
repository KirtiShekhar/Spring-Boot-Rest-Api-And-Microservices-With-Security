package com.springboot.bankingsecurity.controller;

import com.springboot.bankingsecurity.Constant.BankingApplicationConstants;
import com.springboot.bankingsecurity.dto.NoticeRequestDto;
import com.springboot.bankingsecurity.entity.Notice;
import com.springboot.bankingsecurity.service.NoticeService;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class NoticeController
{
    Logger noticeLogger = LoggerFactory.getLogger(NoticeController.class);

    @Autowired
    NoticeService noticeService;

    @GetMapping("/notices/getNotices")
    public List<Notice> getActiveNotices()
    {
        List<Notice> singleNoticeList = new ArrayList<>();
        noticeLogger.info("Get Notice Details For given Id Stored in database");
        try
        {
            noticeLogger.info("invoking noticeService.getNoticeById(noticeId) service");
            singleNoticeList = noticeService.getActiveNotices();
        }
        catch(RuntimeException ex)
        {
            final String errorMessage = ex.getMessage() == null ? BankingApplicationConstants.ERROR_MSG : ex.getMessage();
            noticeLogger.error("Error in get single Notice details : " + errorMessage);
        }

        return singleNoticeList;
    }
}
