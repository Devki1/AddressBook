package com.bridgelabz.addressbook.test;

import com.bridgelabz.addressbook.model.AddressDetails;
import com.bridgelabz.addressbook.model.PersonDetails;
import com.bridgelabz.addressbook.services.IAddressBookService;
import com.bridgelabz.addressbook.services.AddressBookService;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class AddressBookTest {
    AddressDetails addressDetails = null;
    ObjectMapper objectMapper = new ObjectMapper();
    private static String testingFilePath = "/home/user/IdeaProjects/AddressBookProblem/src/main/resources/AddressBook.jason";

    @Test
    public void givenPersonObject_IsWrittenToFile_ShouldReturnTrue() {
        try {
            PersonDetails person = new PersonDetails("Dev", "Gupta", "Govandi", 8543922569L, new AddressDetails("Pune", "MAH", 411014L));

            IAddressBookService iPersonServices = new AddressBookService();
            // AddressDetails addressDetails = null;
            iPersonServices.addPerson(person, addressDetails, testingFilePath);
            ArrayList<PersonDetails> data = objectMapper.readValue(new File(testingFilePath), new TypeReference<ArrayList<PersonDetails>>() {
            });
            Assert.assertEquals(person.getFirstName(), data.get(1).getFirstName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenPersonDtoObject_IfUpdateFile_ShouldReturnTrue() {
        try {
            PersonDetails person = new PersonDetails("Raj", "Gupta", "Govandi", 8543922569L, new AddressDetails("Pune", "MAH", 411014L));


            IAddressBookService iPersonServices = new AddressBookService();
            iPersonServices.updatePerson(person, addressDetails, testingFilePath);

            ArrayList<PersonDetails> data = objectMapper.readValue(new File(testingFilePath), new TypeReference<ArrayList<PersonDetails>>() {
            });
            Assert.assertEquals(person.getFirstName(), data.get(1).getFirstName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenPersonObject_IfDeleted_ShouldReturnTrue() {
        try {
            PersonDetails person = new PersonDetails("Dev", "Gupta", "Govandi", 8543922569L, new AddressDetails("Pune", "MAH", 411014L));
            IAddressBookService iPersonServices = new AddressBookService();
            iPersonServices.deletePerson(person,addressDetails,testingFilePath);

            ArrayList<PersonDetails> data = objectMapper.readValue(new File(testingFilePath), new TypeReference<ArrayList<PersonDetails>>() {
            });
            Assert.assertEquals(true,data.isEmpty());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
