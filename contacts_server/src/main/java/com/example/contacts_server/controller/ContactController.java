package com.example.contacts_server.controller;


import com.example.contacts_server.dto.Contact;
import com.example.contacts_server.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contact")
public class ContactController {
    private final ResponseEntity ERROR = ResponseEntity.badRequest().build();

    @Autowired
    private ContactService contactService;


    @CrossOrigin
    @GetMapping("/{contactId}")
    ResponseEntity<?> getContact(@PathVariable Long contactId){
        try {
            return ResponseEntity.status(HttpStatus.OK.value()).body( contactService.getContactById(contactId));
        }catch (Exception e){
            return ERROR;
        }
    }

    @CrossOrigin
    @GetMapping("")
    ResponseEntity<?> getContacts(){
        try {
            return ResponseEntity.status(HttpStatus.OK.value()).body( contactService.getAllContacts());
        }catch (Exception e){
            return ERROR;
        }
    }


    @CrossOrigin
    @PostMapping("")
    ResponseEntity<?> postContact(@RequestBody Contact contact){
        try {
            return ResponseEntity.status(HttpStatus.OK.value()).body( contactService.addContact(contact));
        }catch (Exception e){
            System.out.println(e.getMessage());
            return ERROR;
        }
    }


    @CrossOrigin
    @PutMapping("")
    ResponseEntity<?> putContact(@RequestBody Contact contact){
        try {
            return ResponseEntity.status(HttpStatus.OK.value()).body( contactService.updateContact(contact));
        }catch (Exception e){
            System.out.println(e.getMessage());
            return ERROR;
        }
    }

    @CrossOrigin
    @DeleteMapping("/{contactId}")
    ResponseEntity<?> deleteContact(@PathVariable Long contactId){
        try {
            contactService.deleteContact(contactId);
            return ResponseEntity.status(HttpStatus.OK.value()).build();
        }catch (Exception e){
            return ERROR;
        }
    }


}
