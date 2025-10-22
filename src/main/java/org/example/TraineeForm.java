package org.example;

import java.util.Scanner;

public class TraineeForm {
    private Scanner scanner;

    public TraineeForm(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getId(){
        System.out.println("Enter Id: ");
        return scanner.nextLine();
    }

    public Trainee getTrainee(){
        System.out.println("Enter ID: ");
        String id = scanner.nextLine().trim();
        if (id.isEmpty()) {
            throw new IllegalArgumentException("Invalid ID");
        }
        System.out.println("Enter Name: ");
        String name = scanner.nextLine();
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Invalid Name");
        }
        System.out.println("Enter Gender: ");
        String gender = scanner.nextLine().trim();
        if (gender.isEmpty() || !(gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female"))) {
            throw new IllegalArgumentException("Invalid Gender");
        }
        System.out.println("Enter Age: ");
        byte age = scanner.nextByte();
        scanner.nextLine();
        if (age <6){
            throw new IllegalArgumentException("Invalid Age");
        }

        Trainee t = new Trainee(id, name, gender, age);
        return t;
    }
}
