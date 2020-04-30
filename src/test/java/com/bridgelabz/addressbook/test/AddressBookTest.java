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
    private static String testFilePath = "/home/user/IdeaProjects/AddressBookProblem/src/main/resources/AddressBook.jason";

    @Test
    public void givenPersonObject_IsWrittenToFile_ShouldReturnTrue() {
        try {
            PersonDetails person = new PersonDetails("Dev", "Gupta", 8543922569L, new AddressDetails("Mumbai", "Govandi", "MAH", 411014L));

            IAddressBookService iAddressBookService = new AddressBookService();
            iAddressBookService.addPerson(person, addressDetails, testFilePath);
            ArrayList<PersonDetails> data = objectMapper.readValue(new File(testFilePath), new TypeReference<ArrayList<PersonDetails>>() {
            });
            Assert.assertEquals(person.getFirstName(), data.get(1).getFirstName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenPersonDtoObject_IfUpdateFile_ShouldReturnTrue() {
        try {
            PersonDetails person = new PersonDetails("Raj", "Gupta", 8543922569L, new AddressDetails("Pune", "Govandi", "MAH", 411014L));


            IAddressBookService iAddressBookService = new AddressBookService();
            iAddressBookService.updatePerson(person, addressDetails, testFilePath);

            ArrayList<PersonDetails> data = objectMapper.readValue(new File(testFilePath), new TypeReference<ArrayList<PersonDetails>>() {
            });
            Assert.assertEquals(person.getFirstName(), data.get(1).getFirstName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenPersonObject_IfDeleted_ShouldReturnTrue() {
        try {
            PersonDetails person = new PersonDetails("xyz", "Gupta", 8543922569L, new AddressDetails("Pune", "Govandi", "MAH", 411014L));
            IAddressBookService iAddressBookService = new AddressBookService();
            iAddressBookService.deletePerson(person, addressDetails, testFilePath);
            ArrayList<PersonDetails> data = objectMapper.readValue(new File(testFilePath), new TypeReference<ArrayList<PersonDetails>>() {
            });
            Assert.assertEquals(true, data.isEmpty());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void Testing_SortByName_Method_IfSorted_ShouldReturnTrue() {
        try {
            ArrayList<PersonDetails> sortingList = new ArrayList<>();

            PersonDetails person0 = new PersonDetails("zeba", "Singh", 8543922569L, new AddressDetails("Pune", "Govandi", "MAH", 411014L));
            PersonDetails person1 = new PersonDetails("bhanu", "Khan", 8543922569L, new AddressDetails("Pune", "Govandi", "MAH", 411014L));
            PersonDetails person2 = new PersonDetails("rahul", "Gupta", 8543922569L, new AddressDetails("Pune", "Govandi", "MAH", 411014L));
            PersonDetails person3 = new PersonDetails("abhi", "Singh", 8543922569L, new AddressDetails("Pune", "Govandi", "MAH", 411014L));
            sortingList.add(person0);
            sortingList.add(person1);
            sortingList.add(person2);
            sortingList.add(person3);
            objectMapper.writeValue(new File(testFilePath), sortingList);

            IAddressBookService iAddressBookService = new AddressBookService();
            iAddressBookService.sortByPersonName(testFilePath);
            ArrayList<PersonDetails> data = objectMapper.readValue(new File(testFilePath), new TypeReference<ArrayList<PersonDetails>>() {
            });

            Assert.assertEquals(sortingList.get(3).getFirstName(), data.get(0).getFirstName());
            Assert.assertEquals(sortingList.get(1).getFirstName(), data.get(1).getFirstName());
            Assert.assertEquals(sortingList.get(2).getFirstName(), data.get(2).getFirstName());
            Assert.assertEquals(sortingList.get(0).getFirstName(), data.get(3).getFirstName());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
