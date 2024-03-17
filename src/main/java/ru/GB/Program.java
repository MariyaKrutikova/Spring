package ru.GB;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class Program {
    public static void main(String[] args) {

        Gson gson = new Gson();

//-------------сериализация----------------------
        try (FileWriter fileWriter = new FileWriter("myJsom.json")){
            fileWriter.write(gson.toJson(new Person("Bob", "Smit", 30)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//-----------десериализация-------------------
        try {
            BufferedReader reader = new BufferedReader(new FileReader("myJsom.json"));
            Person newPerson = gson.fromJson(reader, Person.class);
            System.out.println(newPerson);
        } catch (FileNotFoundException ex) {
            ex.getStackTrace();
        }
    }
}
