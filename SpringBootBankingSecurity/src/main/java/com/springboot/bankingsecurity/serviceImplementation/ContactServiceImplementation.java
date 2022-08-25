package com.springboot.bankingsecurity.serviceImplementation;

import com.springboot.bankingsecurity.dto.ContactRequestDto;
import com.springboot.bankingsecurity.entity.Contact;
import com.springboot.bankingsecurity.repository.ContactRepository;
import com.springboot.bankingsecurity.service.ContactService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImplementation implements ContactService
{
    @Autowired
    ContactRepository contactRepository;

    @Override
    public Contact saveContactInquiryDetails(ContactRequestDto contactRequestDto)
    {
        Contact contact = new Contact();
        contactRequestDto.setCreateDt(LocalDate.now().toString());
        BeanUtils.copyProperties(contactRequestDto,contact);
        Contact savedContact = contactRepository.saveAndFlush(contact);
        return savedContact;
    }

    @Override
    public Contact getContactInquiryDetailById(Long contactId)
    {
        Contact singleContact;
        Optional<Contact> existContact = contactRepository.findById(contactId);
        if(existContact.isPresent())
        {
            singleContact = existContact.get();
        }
        else
        {
            throw new RuntimeException("Contact Details with given id not exist");
        }
        return singleContact;
    }

    @Override
    public List<Contact> getAllContactInquiryDetails()
    {
        List<Contact> contactList = new ArrayList<>();
        contactList = contactRepository.findAll();
        return contactList;
    }
}
