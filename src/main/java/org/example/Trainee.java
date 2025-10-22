package org.example;

public class Trainee {
    private String id;
    private String name;
    private String gender;
    private byte age;


    public Trainee(String id, String name, String gender, byte age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public Trainee() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id != null) {
            this.id = id;
        }
        else{
            throw new IllegalArgumentException("id is null");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null) {
            this.name = name;
        }
        else{
            throw new IllegalArgumentException("name is null");
        }
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (gender != null && (gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female"))) {
            this.gender = gender;
        }
        else{
            throw new IllegalArgumentException("gender is must be male/female");
        }
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        if (age >= 6){
            this.age = age;
        }
        else{
            throw new IllegalArgumentException("age must be >= 6");
        }
    }

    @Override
    public String toString() {
        return "Trainee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }
}
