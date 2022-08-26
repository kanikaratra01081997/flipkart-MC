package com.machineCodingPractice.LLD.model;

import lombok.Data;

@Data
public class Person {
    public String name, email, phone;

    public Person(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

}