package com.bridgelabz.addressbook.services;

import com.bridgelabz.addressbook.model.PersonDetails;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class FileSystem {
    ObjectMapper objectMapper = new ObjectMapper();

    public ArrayList<PersonDetails> readFile(String filePath) throws IOException {
        ArrayList<PersonDetails> data = objectMapper.readValue(new File(filePath), new TypeReference<ArrayList<PersonDetails>>() {
        });
        return data;
    }

    public void writeFile(ArrayList<PersonDetails> list, String filePath) throws IOException {
        objectMapper.writeValue(new File(filePath), list);
    }
}