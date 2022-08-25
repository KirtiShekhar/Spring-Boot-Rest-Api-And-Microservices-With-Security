package com.springboot.bankingsecurity.controller;

import com.springboot.bankingsecurity.Constant.BankingApplicationConstants;
import com.springboot.bankingsecurity.dto.ContactRequestDto;
import com.springboot.bankingsecurity.entity.Contact;
import com.springboot.bankingsecurity.service.ContactService;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ContactController
{
    Logger contactLogger = LoggerFactory.getLogger(ContactController.class);

    @Autowired
    ContactService contactService;

    @PostMapping("/contact/saveContact")
    public Contact saveContactInquiryDetails(@RequestBody ContactRequestDto contactRequestDto)
    {
        Contact savedContacts = new Contact();
        contactLogger.info("Inserting new Contact to database");
        try
        {
            contactLogger.info("invoking contactService.saveContactInquiryDetails(contactRequestDto) service");
            savedContacts = contactService.saveContactInquiryDetails(contactRequestDto);
        }
        catch(RuntimeException ex)
        {
            final String errorMessage = ex.getMessage() == null ? BankingApplicationConstants.ERROR_MSG : ex.getMessage();
            contactLogger.error("Error in insert Contact : " + errorMessage);
        }

        return savedContacts;
    }
}
