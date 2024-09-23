package com.example.contacts_server;

import com.example.contacts_server.dto.Contact;
import com.example.contacts_server.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ContactsServerApplication {



    public static void main(String[] args) {
        SpringApplication.run(ContactsServerApplication.class, args);



}

}
