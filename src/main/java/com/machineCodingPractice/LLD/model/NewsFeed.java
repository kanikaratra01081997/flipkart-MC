package com.machineCodingPractice.LLD.model;

import javafx.geometry.Pos;

import java.time.LocalDateTime;

public class NewsFeed {
    Post post;

    // due to time constraint
    int localDateTime;

   public NewsFeed(Post post, int l)
   {
       this.post=post;
       this.localDateTime=l;
   }
}
