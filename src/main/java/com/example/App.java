package com.example;

import java.util.HashMap;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        HashMap<String, String> birthdayMap = new HashMap<>();

        birthdayMap.put("Lupita", "January 5");
        birthdayMap.put("Antonio", "March 12");
        birthdayMap.put("Maria", "July 20");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a name: ");
        String name = scanner.nextLine();

        if (birthdayMap.containsKey(name)) {
            System.out.println(name + "'s birthday is " + birthdayMap.get(name));
        } else {
            System.out.println("Birthday unknown");
        }

        scanner.close();
    }
}