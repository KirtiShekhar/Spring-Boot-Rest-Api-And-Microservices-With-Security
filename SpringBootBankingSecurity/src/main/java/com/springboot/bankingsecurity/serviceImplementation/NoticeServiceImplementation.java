package com.springboot.bankingsecurity.serviceImplementation;

import com.springboot.bankingsecurity.dto.NoticeRequestDto;
import com.springboot.bankingsecurity.entity.Customer;
import com.springboot.bankingsecurity.entity.Notice;
import com.springboot.bankingsecurity.repository.NoticeRepository;
import com.springboot.bankingsecurity.service.NoticeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NoticeServiceImplementation implements NoticeService
{
    @Autowired
    NoticeRepository noticeRepository;

    @Override
    public Notice saveNotice(NoticeRequestDto noticeRequestDto)
    {
        Notice notice = new Notice();
        noticeRequestDto.setNoticeBegDt(LocalDateTime.now().toString());
        noticeRequestDto.setNoticeEndDt(LocalDateTime.now().toString());
        noticeRequestDto.setCreateDt(LocalDateTime.now().toString());
        noticeRequestDto.setUpdateDt(LocalDateTime.now().toString());
        BeanUtils.copyProperties(noticeRequestDto,notice);
        Notice savedNotice = noticeRepository.saveAndFlush(notice);
        return savedNotice;
    }

    @Override
    public Notice getNoticeById(Long noticeId)
    {
        Notice singleNotice;
        Optional<Notice> existNotice = noticeRepository.findById(noticeId);
        if(existNotice.isPresent())
        {
            singleNotice = existNotice.get();
        }
        else
        {
            throw new RuntimeException("Notice with given id not exist");
        }
        return singleNotice;
    }

    @Override
    public List<Notice> getNotices()
    {
        List<Notice> noticeList = new ArrayList<>();
        noticeList = noticeRepository.findAll();
        return noticeList;
    }

    @Override
    public List<Notice> getActiveNotices()
    {
        List<Notice> activeNoticeList = new ArrayList<>();
        activeNoticeList = noticeRepository.findAllActiveNotices();
        return activeNoticeList;
    }
}
