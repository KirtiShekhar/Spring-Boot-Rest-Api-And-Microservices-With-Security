package com.springboot.bankingsecurity.service;

import com.springboot.bankingsecurity.dto.ContactRequestDto;
import com.springboot.bankingsecurity.entity.Contact;
import java.util.List;

public interface ContactService
{
    Contact saveContactInquiryDetails(ContactRequestDto contactRequestDto);
    Contact getContactInquiryDetailById(Long contactId);
    List<Contact> getAllContactInquiryDetails();
}
