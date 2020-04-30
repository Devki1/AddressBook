package com.bridgelabz.addressbook.services;

import com.bridgelabz.addressbook.model.Person;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class FileSystem {
    ObjectMapper objectMapper = new ObjectMapper();

    public ArrayList<Person> readFile(String filePath) throws IOException {
        ArrayList<Person> addressData = objectMapper.readValue(new File(filePath), new TypeReference<ArrayList<Person>>() {
        });
        return addressData;
    }

    public void writeFile(ArrayList<Person> list, String filePath) throws IOException {
        objectMapper.writeValue(new File(filePath), list);
    }

}

