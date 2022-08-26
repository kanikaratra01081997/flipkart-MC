package com.machineCodingPractice.LLD.model;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
public class Post {
    public Member owner;
    public String postId, text;
    public int totalLikes;
    public int disLikes;
    public List<Comment> comments;


    public Post(Member owner, String postId, String text) {
        this.owner = owner;
        this.postId = postId;
        this.text = text;
        this.totalLikes = 0;
        this.disLikes = 0;
        this.comments = new ArrayList<>();
    }

    public void addLike() {
        totalLikes++;
    }


    public void addDisLike() {
        disLikes++;
    }


    public void addComment(Comment comment)
    {
        comments.add(comment);
    }
}