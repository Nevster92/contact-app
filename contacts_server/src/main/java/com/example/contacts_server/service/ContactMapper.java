package com.example.contacts_server.service;


import com.example.contacts_server.dto.Contact;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ContactMapper {

    @Mapping(target = "id", ignore = true)
    void updateContactFromDto(Contact newContact, @MappingTarget Contact contact );

}




