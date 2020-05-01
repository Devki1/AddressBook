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
    String fileFolderDestination = "/home/user/IdeaProjects/AddressBookProblem/src/main/resources/";

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
    public Boolean createAddressBook(String fileName) {
        File file = new File(fileFolderDestination + fileName);
        try {
            if (file.createNewFile()) {
                System.out.println("File is created!");
                return true;
            } else {
                System.out.println("File already exists.");
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean openExistingAddressBook(String fileName) {
        File openFile = new File(fileFolderDestination + fileName);
        if (openFile.exists())
            return true;
        return false;
    }

    @Override
    public String deleteFile(String fileName) {
        File openFile = new File(fileFolderDestination + fileName);
        if (openFile.delete())
            return "file deleted successfully";
        else
            return "file not found to delete";
    }

    @Override
    public void saveAddressBook(String path, ArrayList<PersonDetails> dataList) {
        try {
            fileSystem.writeFile(dataList, path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
