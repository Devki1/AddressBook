package com.bridgelabz.addressbook.services;

import com.bridgelabz.addressbook.model.Person;

import java.io.IOException;
import java.util.ArrayList;

public class AddressBookService implements IAddressBookService {
    FileSystem fileSystem = new FileSystem();

    @Override
    public void addPerson(Person person, String filePath) {
        try {
            ArrayList<Person> fileAddressData = fileSystem.readFile(filePath);
            fileAddressData.add(person);
            fileSystem.writeFile(fileAddressData,filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}