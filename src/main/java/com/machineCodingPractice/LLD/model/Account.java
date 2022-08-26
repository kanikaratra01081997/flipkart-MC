package com.machineCodingPractice.LLD.model;

import com.machineCodingPractice.LLD.constant.AccountStatus;
import lombok.Data;

@Data
public class Account {

    public String id, password;
    public Person person;
    public AccountStatus status;

    public Account(String id, String password, Person person, AccountStatus status) {
        this.id = id;
        this.password = password;
        this.person = person;
        this.status = status;
    }

    public void resetPassword() {
        this.password = "";
    }
}