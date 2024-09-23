package com.example.contacts_server.repository;

import com.example.contacts_server.dto.Contact;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ContactRepository extends JpaRepository<Contact, Long> {

}


