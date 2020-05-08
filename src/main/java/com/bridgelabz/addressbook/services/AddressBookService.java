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

    //This method is used to add person detail informatiion.
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

    //This method is used to update person information.
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

    // This method is used to delete person information.
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

    // This method is used to sort data by name
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

    // This method is used to print entries data.
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

    // This method is used to create new json file.
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

    // This method is used to open existing data of from address book.
    @Override
    public Boolean openExistingAddressBook(String fileName) {
        File openFile = new File(fileFolderDestination + fileName);
        if (openFile.exists())
            return true;
        return false;
    }

    //This method is used to delete the file
    @Override
    public String deleteFile(String fileName) {
        File openFile = new File(fileFolderDestination + fileName);
        if (openFile.delete())
            return "file deleted successfully";
        else
            return "file not found to delete";
    }

    //This method is used to save data of address book
    @Override
    public void saveAddressBook(String path, ArrayList<PersonDetails> dataList) {
        try {
            fileSystem.writeFile(dataList, path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //This method is used to save as data of address book
    @Override
    public boolean saveAsAddressBook(String filePath, PersonDetails personDetails) {
        try {
            ArrayList<PersonDetails> fileData = fileSystem.readFile(filePath);
            if (fileData.isEmpty())
                return false;
            fileSystem.writeFile(fileData, filePath);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    // This method is used to exit  from address book.
    @Override
    public void quitAddressBook() {
        System.out.println("Exit..");
        System.exit(0);
    }
}

