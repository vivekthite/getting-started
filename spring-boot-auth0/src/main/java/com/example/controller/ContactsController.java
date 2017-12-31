/*
 * All Rights Reserved. Synerzip 2017
 */
package com.example.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Contact;
import com.google.common.collect.Lists;

/**
 * @author vivekanandt
 *
 */
@RestController
@RequestMapping(value = "/contacts/")
public class ContactsController {

    private static final List<Contact> contacts = Lists.newArrayList(
                    Contact.builder().name("Bruno Krebs").phone("+5551987654321").build(),
                    Contact.builder().name("John Doe").phone("+5551888884444").build());

    @GetMapping
    @PreAuthorize("hasAuthority('read:contacts')")
    public List<Contact> getContacts() {
        return contacts;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('add:contacts')")
    public void addContact(@RequestBody Contact contact) {
        contacts.add(contact);
    }
}