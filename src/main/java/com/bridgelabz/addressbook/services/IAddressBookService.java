package com.bridgelabz.addressbook.services;

import com.bridgelabz.addressbook.model.AddressDetails;
import com.bridgelabz.addressbook.model.PersonDetails;

import java.util.ArrayList;
import java.util.List;

public interface IAddressBookService {
    void addPerson(PersonDetails person, AddressDetails addressDetails, String filePath);

    void updatePerson(PersonDetails person, AddressDetails addressDetails, String filePath);

    void deletePerson(PersonDetails person, AddressDetails addressDetails, String filePath);

    void sortByPersonName(String filePath);

    List printEntries(String filePath);

    Boolean createAddressBook(String fileName);

    Boolean openExistingAddressBook(String fileName);

    String deleteFile(String fileName);

    public void saveAddressBook(String path, ArrayList<PersonDetails> data);

    public boolean saveAsAddressBook(String filePath, PersonDetails personDetails);
}