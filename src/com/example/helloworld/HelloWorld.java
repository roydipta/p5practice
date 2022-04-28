package com.example.helloworld;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.*;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

public class HelloWorld {
    class Model{
        List<String> jsonLines;
    }
    private static HashMap<String, List<String>> lines= new HashMap<>();
    private static HashMap<String, List<String>> journeys = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("hello");
        Gson gson = new Gson();
        BufferedReader br = null;
        System.out.println("here");
        try {
//            System.out.println("before read");
//            br = new BufferedReader(new FileReader("sample.json" ));
//            System.out.println("after read");
//            Type type = new TypeToken<List<Model>>(){}.getType();
//            System.out.println("created new ");
//            Model models = gson.fromJson(br, type);
//
//
//            for(String s: models.jsonLines){
//                System.out.println(s);}
//            System.out.println(models.jsonLines);
//            System.out.println("gson m");

            Reader reader=new BufferedReader(new FileReader(new File("sample.json")));

            Type type = new TypeToken<Map<String, Map<String, List<String>>>>() {}.getType();
            Map<String, Map<String, String>> data = new Gson().fromJson(reader, type);
            System.out.println(data.get("lines"));
            System.out.println(data.get("trips"));


// pretty printing
//            System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(data));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
