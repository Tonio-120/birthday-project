package com.example;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class App {

    private static HashMap<String, String> birthdayMap = new HashMap<>();

    public static void initializeMap(String fileName) {
        try (FileReader reader = new FileReader(fileName)) {

            JsonArray jsonData = JsonParser.parseReader(reader).getAsJsonArray();

            for (JsonElement element : jsonData) {
                JsonObject obj = element.getAsJsonObject();

                String name = obj.get("name").getAsString();
                String birthday = obj.get("birthday").getAsString();

                birthdayMap.put(name, birthday);
            }

        } catch (Exception e) {
            System.out.println("Error reading JSON file");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        // IMPORTANT: this matches your current file location
        initializeMap("src/main/java/com/example/birthday.json");

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a name: ");
        String name = input.nextLine();

        if (birthdayMap.containsKey(name)) {
            System.out.println(name + "'s birthday is " + birthdayMap.get(name));
        } else {
            System.out.println("Birthday unknown");
        }

        input.close();
    }
}