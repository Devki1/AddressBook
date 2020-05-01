package com.bridgelabz.addressbook.services;

import com.bridgelabz.addressbook.model.AddressDetails;
import com.bridgelabz.addressbook.model.PersonDetails;

import java.io.IOException;
import java.util.List;

public interface IAddressBookService {
    void addPerson(PersonDetails person, AddressDetails addressDetails, String filePath);

    void updatePerson(PersonDetails person, AddressDetails addressDetails, String filePath);

    void deletePerson(PersonDetails person, AddressDetails addressDetails, String filePath);

    void sortByPersonName(String filePath);

    List printEntries(String filePath);

    void sortByPersonZipCode(String filePath);

    public String createNewFile(String destinationFolder, String fileName) throws IOException;
}