package com.srilakshmi.app.model;

public class Patient {
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String gethospitalName() {
        return hospitalName;
    }

    public String getgender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    String id;
    String name;
    String hospitalName;
    String gender;
    int age;

    public Patient() {
    }

    public Patient(String id, String name, int age) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
    }
}