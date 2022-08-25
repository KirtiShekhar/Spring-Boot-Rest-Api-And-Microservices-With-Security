package com.springboot.bankingsecurity.restController;

import com.springboot.bankingsecurity.dto.ContactRequestDto;
import com.springboot.bankingsecurity.entity.Contact;
import com.springboot.bankingsecurity.service.ContactService;
import com.springboot.bankingsecurity.Constant.BankingApplicationConstants;
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
@RequestMapping("/contact")
public class ContactRestController
{
    Logger contactLogger = LoggerFactory.getLogger(ContactRestController.class);

    @Autowired
    ContactService contactService;

    @PostMapping(value = "/saveContact",consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "insert new Contact in the database")
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

    @GetMapping(value = "/getAllContacts",produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get All Contact Details Stored in database")
    public List<Contact> getAllContactInquiryDetails()
    {
        List<Contact> contactsResponseList = new ArrayList<>();
        contactLogger.info("Get All Contact Details Stored in database");
        try
        {
            contactLogger.info("invoking contactService.getAllContactInquiryDetails() service");
            contactsResponseList = contactService.getAllContactInquiryDetails();
        }
        catch(RuntimeException ex)
        {
            final String errorMessage = ex.getMessage() == null ? BankingApplicationConstants.ERROR_MSG : ex.getMessage();
            contactLogger.error("Error in get all Contact details : " + errorMessage);
        }

        return contactsResponseList;
    }

    @GetMapping(value = "/getSingleContact/{contactId}",produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get Contact Details For given Id Stored in database")
    public Contact getContactInquiryDetailById(@PathVariable Long contactId)
    {
        Contact singleContact = new Contact();
        contactLogger.info("Get Contact Details For given Id Stored in database");
        try
        {
            contactLogger.info("invoking contactService.getContactInquiryDetailById(contactId) service");
            singleContact = contactService.getContactInquiryDetailById(contactId);
        }
        catch(RuntimeException ex)
        {
            final String errorMessage = ex.getMessage() == null ? BankingApplicationConstants.ERROR_MSG : ex.getMessage();
            contactLogger.error("Error in get single Contact details : " + errorMessage);
        }

        return singleContact;
    }
}
