package com.bridgelabz.addressbook.services;

import com.bridgelabz.addressbook.model.Person;

public interface IAddressBookService {
    void addPerson(Person person, String filePath);

}