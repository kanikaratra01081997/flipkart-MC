package com.machineCodingPractice.LLD.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class Comment {

    public String text;
    public int id;
    public Member member;

    public Comment(String text , int id ,Member member)
    {
        this.id=id;
        this.text=text;
        this.member=member;

    }


}
