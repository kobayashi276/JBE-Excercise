package org.collections;

import java.util.ArrayList;
import java.util.Scanner;

public class Course {
    private String code;
    private String name;
    private boolean status;
    private short duration;
    private String flag;

    public Course() {}

    public Course(String code, String name, boolean status, short duration, String flag) {
        this.code = code;
        this.name = name;
        this.status = status;
        this.duration = duration;
        this.flag = flag;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public short getDuration() {
        return duration;
    }

    public void setDuration(short duration) {
        this.duration = duration;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Course{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", duration=" + duration +
                ", flag='" + flag + '\'' +
                '}';
    }

    public void input(Scanner sc, ArrayList<Course> courses) {
        System.out.println("Enter code: ");
        String code = sc.nextLine();
        if (!Validator.validateCode(code)){
            System.out.println("Invalid code");
            return;
        }
        if (Validator.isDuplicatedCode(code,courses)){
            System.out.println("Duplicated code");
            return;
        }

        System.out.println("Enter name: ");
        String name = sc.nextLine().trim().toLowerCase();

        System.out.println("Enter status: ");
        String validateStatusText = sc.nextLine().trim().toLowerCase();
        if (!Validator.validateStatus(validateStatusText)){
            System.out.println("Invalid status");
            return;
        }
        boolean status = validateStatusText.equals("active");;

        System.out.println("Enter duration: ");
        short duration = sc.nextShort();
        sc.nextLine();
        if (!Validator.validateDuration(duration)){
            System.out.println("Invalid duration");
            return;
        }

        System.out.println("Enter flag: ");
        String flag = sc.nextLine().trim().toLowerCase();
        if (!Validator.validateFlag(flag)){
            System.out.println("Invalid flag");
            return;
        }

        Course course = new Course(code, name, status, duration, flag);
        courses.add(course);
    }
}
