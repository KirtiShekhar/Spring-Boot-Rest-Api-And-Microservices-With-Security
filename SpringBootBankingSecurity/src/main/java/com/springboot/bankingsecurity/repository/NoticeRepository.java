package com.springboot.bankingsecurity.repository;

import com.springboot.bankingsecurity.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeRepository  extends JpaRepository<Notice,Long>
{
    @Query(value = "from Notice n where CURDATE() BETWEEN noticeBegDt AND noticeEndDt")
    List<Notice> findAllActiveNotices();
}
