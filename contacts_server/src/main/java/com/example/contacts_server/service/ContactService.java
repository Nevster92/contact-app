package com.example.contacts_server.service;

import com.example.contacts_server.dto.Contact;
import com.example.contacts_server.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private ContactMapper contactMapper;

    public Contact getContactById(Long contactId){
        return contactRepository.getOne(contactId);
    }

    public List<Contact> getAllContacts(){
        return contactRepository.findAll();
    }

    public Contact addContact(Contact contact){
        contact.setId(null);
        contactRepository.save(contact);
        return contact;
    }

    public Contact updateContact(Contact newContact){
        Contact originalContact = getContactById(newContact.getId());

        contactMapper.updateContactFromDto(newContact, originalContact);
        contactRepository.save(originalContact);
        return contactRepository.getOne(originalContact.getId());
    }

    public void deleteContact(Long contactId){
        contactRepository.deleteById(contactId);
    }
}
