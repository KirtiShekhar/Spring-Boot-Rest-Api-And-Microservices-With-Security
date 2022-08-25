package com.springboot.bankingsecurity.restController;

import com.springboot.bankingsecurity.Constant.BankingApplicationConstants;
import com.springboot.bankingsecurity.dto.NoticeRequestDto;
import com.springboot.bankingsecurity.entity.Notice;
import com.springboot.bankingsecurity.service.NoticeService;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/notices")
public class NoticeRestController
{
    Logger noticeLogger = LoggerFactory.getLogger(NoticeRestController.class);

    @Autowired
    NoticeService noticeService;

    @PostMapping(value = "/saveNotice",consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "insert new Notice in the database")
    public Notice saveNotice(@RequestBody NoticeRequestDto noticeRequestDto)
    {
        Notice savedNotice = new Notice();
        noticeLogger.info("Inserting new Notice to database");
        try
        {
            noticeLogger.info("invoking noticeService.saveNotice(noticeRequestDto) service");
            savedNotice = noticeService.saveNotice(noticeRequestDto);
        }
        catch(RuntimeException ex)
        {
            final String errorMessage = ex.getMessage() == null ? BankingApplicationConstants.ERROR_MSG : ex.getMessage();
            noticeLogger.error("Error in insert Notice : " + errorMessage);
        }

        return savedNotice;
    }

    @GetMapping(value = "/getAllNotices",produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get All Notice Details Stored in database")
    public List<Notice> getNotices()
    {
        List<Notice> noticesResponseList = new ArrayList<>();
        noticeLogger.info("Get All Notice Details Stored in database");
        try
        {
            noticeLogger.info("invoking noticeService.getNotices() service");
            noticesResponseList = noticeService.getNotices();
        }
        catch(RuntimeException ex)
        {
            final String errorMessage = ex.getMessage() == null ? BankingApplicationConstants.ERROR_MSG : ex.getMessage();
            noticeLogger.error("Error in get all Notice details : " + errorMessage);
        }

        return noticesResponseList;
    }

    @GetMapping(value = "/getSingleNotice/{noticeId}",produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get Notice Details For given Id Stored in database")
    public Notice getNoticeById(@PathVariable Long noticeId)
    {
        Notice singleNotice = new Notice();
        noticeLogger.info("Get Notice Details For given Id Stored in database");
        try
        {
            noticeLogger.info("invoking noticeService.getNoticeById(noticeId) service");
            singleNotice = noticeService.getNoticeById(noticeId);
        }
        catch(RuntimeException ex)
        {
            final String errorMessage = ex.getMessage() == null ? BankingApplicationConstants.ERROR_MSG : ex.getMessage();
            noticeLogger.error("Error in get single Notice details : " + errorMessage);
        }

        return singleNotice;
    }
}
