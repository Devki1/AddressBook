package com.bridgelabz.addressbook.services;

import com.bridgelabz.addressbook.model.AddressDetails;
import com.bridgelabz.addressbook.model.PersonDetails;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AddressBookService implements IAddressBookService {
    FileSystem fileSystem = new FileSystem();

    @Override
    public void addPerson(PersonDetails person, AddressDetails addressDetails, String filePath) {
        try {
            ArrayList<PersonDetails> fileData = fileSystem.readFile(filePath);
            fileData.add(person);
            fileSystem.writeFile(fileData, filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updatePerson(PersonDetails person, AddressDetails addressDetails, String filePath) {
        try {
            ArrayList<PersonDetails> fileData = fileSystem.readFile(filePath);
            for (PersonDetails personDetails : fileData) {
                // if (personDetails.equalsIgnoreCase(personDetails.getLastName()))
                if (personDetails.getFirstName().equalsIgnoreCase(personDetails.getFirstName())) {
                    personDetails.setAddressDetailsObject(personDetails.getAddressDetailsObject());
                    addressDetails.setCity(addressDetails.getCity());
                    addressDetails.setState(addressDetails.getState());
                    addressDetails.setZip(addressDetails.getZip());
                }
            }
            fileSystem.writeFile(fileData, filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePerson(PersonDetails person, AddressDetails addressDetails, String filePath) {
        try {
            ArrayList<PersonDetails> fileData = fileSystem.readFile(filePath);
            PersonDetails delPerson = null;
            for (PersonDetails personDetails : fileData) {
                if (personDetails.getLastName().equalsIgnoreCase(person.getLastName()) && personDetails.getFirstName().equalsIgnoreCase(person.getFirstName())) {
                    delPerson = personDetails;
                    break;
                }
            }
            fileData.remove(delPerson);
            fileSystem.writeFile(fileData, filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sortByPersonName(String filePath) {
        try {
            ArrayList<PersonDetails> fileData = fileSystem.readFile(filePath);
            fileData.sort(Comparator.comparing(PersonDetails::getFirstName));
            fileSystem.writeFile(fileData, filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sortByPersonZipCode(String filePath) {
    }

    @Override
    public List printEntries(String filePath) {
        try {
            ArrayList<PersonDetails> fileData = fileSystem.readFile(filePath);
            fileData.forEach(System.out::println);
            return fileData;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String createNewFile(String destinationFile, String fileName) throws IOException {
        String destinationFolder = "/home/user/IdeaProjects/AddressBookProblem/src/main/resources";
        String fullPath = destinationFolder + fileName;
        try {
            File file = new File(fullPath);
            if (file.createNewFile())
                return "True";
            else
                return "False";

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}


