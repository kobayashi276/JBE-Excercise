package org.example;

import java.util.Scanner;

public class TrainingManagement {
    private final TraineeForm traineeForm;
    private final Scanner scanner;
    private final Trainee listOfTrainee[] = new Trainee[100];
    private byte count;

    public TrainingManagement() {
        scanner = new Scanner(System.in);
        this.traineeForm = new TraineeForm(scanner);
    }

    private void addTrainee() {
        Trainee trainee = traineeForm.getTrainee();
        for (int i = 0; i < count; i++) {
            if (listOfTrainee[i].getId().equals(trainee.getId())) {
                System.out.println("ID is existed.");
                return;
            }
        }
        listOfTrainee[count] = trainee;
        count++;
    }

    private void displayAllTrainee() {
        for (int i = 0; i < count; i++) {
            System.out.println(listOfTrainee[i]);
        }
    }

    private Trainee findTraineeById(String id) {
        for (int i = 0; i < count; i++) {
            if (listOfTrainee[i].getId().equals(id)) {
                return listOfTrainee[i];
            }
        }
        return null;
    }

    private Trainee[] findTraineeByName(String name) {
        Trainee[] trainee = new Trainee[100];
        byte count = 0;
        for (int i = 0; i < this.count; i++) {
            if (listOfTrainee[i].getName().equals(name)) {
                trainee[count] = listOfTrainee[i];
                count++;
            }
        }
        return trainee;
    }

    private void updateTrainee(Trainee trainee) {
        for (int i = 0; i < count; i++) {
            if (listOfTrainee[i].getId().equals(trainee.getId())) {
                listOfTrainee[i].setName(trainee.getName());
                listOfTrainee[i].setGender(trainee.getGender());
                listOfTrainee[i].setAge(trainee.getAge());
            }
        }
    }

    public static void main(String[] args) {
        TrainingManagement trainingManagement = new TrainingManagement();
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("1. Add Trainee");
            System.out.println("2. Display all Trainee");
            System.out.println("3. Find Trainee by ID");
            System.out.println("4. Find Trainee by Name");
            System.out.println("5. Update Trainee by ID");
            System.out.println("6. Exit");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> trainingManagement.addTrainee();
                case "2" -> trainingManagement.displayAllTrainee();
                case "3" -> {
                    System.out.println("Enter Trainee ID: ");
                    String id = scanner.nextLine().trim();

                    Trainee foundTrainee = trainingManagement.findTraineeById(id);
                    if (foundTrainee != null) {
                        System.out.println(foundTrainee.toString());
                    }
                    else {
                        System.out.println("Trainee not found");
                    }
                }
                case "4" -> {
                    System.out.println("Enter Trainee Name: ");
                    String name = scanner.nextLine();

                    Trainee[] foundTrainee = trainingManagement.findTraineeByName(name);

                    for (Trainee trainee : foundTrainee) {
                        if (trainee != null) {
                            System.out.println(trainee);
                        }
                    }
                }
                case "5" -> {
                    System.out.println("Enter Trainee ID: ");
                    String id = scanner.nextLine().trim();
                    System.out.println("Enter Trainee Name: ");
                    String name = scanner.nextLine().trim();
                    System.out.println("Enter Trainee Gender: ");
                    String gender = scanner.nextLine().trim();
                    System.out.println("Enter Trainee Age: ");
                    byte age = scanner.nextByte();
                    scanner.nextLine();

                    Trainee newTrainee = new Trainee(id, name, gender, age);
                    trainingManagement.updateTrainee(newTrainee);
                }
                case "6" -> {
                    return;
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }



}
