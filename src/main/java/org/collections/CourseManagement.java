package org.collections;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CourseManagement {
    private ArrayList<Course> courses = new ArrayList<Course>();

    public CourseManagement() {
    }

    public void input(Scanner sc) {
        Course course = new Course();
        course.input(sc, this.courses);
        System.out.println("Add course successfully.");
    }

    public ArrayList<Course> search(String type, Object data) {
        return courses.stream()
                .filter(course -> {
                    switch (type.toLowerCase()) {
                        case "code":
                            return course.getCode().equalsIgnoreCase((String) data);
                        case "name":
                            return course.getName().equalsIgnoreCase((String) data);
                        case "status":
                            return Boolean.toString(course.isStatus()).equalsIgnoreCase((String) data);
                        case "duration":
                            return Short.toString(course.getDuration()).equals((String) data);
                        case "flag":
                            return course.getFlag().equalsIgnoreCase((String) data);
                        default:
                            System.out.println("Invalid search type.");
                            return false;
                    }
                })
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public void displayAll(String flag) {
        if (Validator.validateFlag(flag)) {
            for (Course course : courses) {
                if (course.getFlag().equalsIgnoreCase(flag)) {
                    System.out.println(course);
                }
            }
        } else {
            System.out.println("Invalid search type.");
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CourseManagement courseManagement = new CourseManagement();
        final int CREATE = 1;
        final int SEARCH = 2;
        final int DISPLAY = 3;
        final int QUIT = 4;

        byte choice;

        do {
            System.out.println("1. Create a course");
            System.out.println("2. Search courses");
            System.out.println("3. Display all courses");
            System.out.println("4. Quit");
            choice = sc.nextByte();
            sc.nextLine();

            switch (choice) {
                case CREATE:
                    courseManagement.input(sc);
                    break;
                case SEARCH:
                    System.out.println("Enter type: (code, name, status, duration, flag)");
                    String type = sc.nextLine().trim().toLowerCase();
                    System.out.println("Enter data:");
                    String data = sc.nextLine().trim().toLowerCase();
                    ArrayList<Course> result = courseManagement.search(type, data);
                    if (result.isEmpty()) {
                        System.out.println("No course found.");
                    } else {
                        for (Course course : result) {
                            System.out.println(course);
                        }
                    }
                    break;
                case DISPLAY:
                    System.out.println("Enter type: (optional, prerequisite, N/A");
                    String flag = sc.nextLine().trim().toLowerCase();
                    courseManagement.displayAll(flag);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        while (choice != QUIT);
    }
}
