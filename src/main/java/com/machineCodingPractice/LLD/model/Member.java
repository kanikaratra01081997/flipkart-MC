package com.machineCodingPractice.LLD.model;

import com.machineCodingPractice.LLD.constant.AccountStatus;
import com.machineCodingPractice.LLD.exceptions.NoMemberPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


public class Member extends  Account{

    private int id;
    public List<Member> following;
    public List<Member> followers;
    public List<Post> posts;

    public PriorityQueue<NewsFeed> newsFeeds;



    public Member(String id, String password, Person person, AccountStatus status, int memberId)
    {
        super(id, password, person,status);
        this.id=memberId;
        this.followers = new ArrayList<Member>();
        this.following= new ArrayList<Member>();
        this.posts= new ArrayList<Post>();
        this.newsFeeds= new PriorityQueue<>((a,b) -> (b.localDateTime-a.localDateTime) );
    }


    public void createPost(Post post)
    {
        posts.add(post);
    }

    public void addFollower(Member member)
    {

        followers.add(member);
    }

    public void removeFollower(Member member)
    {
        try {
            followers.remove(member);
        }catch (Exception e)
        {
           throw  new NoMemberPresent("member not present");
        }
    }


    public void addFollowing(Member m)
    {
        following.add(m);
    }


    public void removeFollowing(Member m)
    {
        try {
            following.remove(m);
        }catch (Exception e)
        {
            throw  new NoMemberPresent("Member not present");
        }

    }



    public void addPostOfFollowingToNewsFeed()
    {

     for(int i=0;i<following.size();i++)
     {
         Member m = followers.get(i);
        // post
         List<Post> postList =m.posts;

         for(int j=postList.size();j>=0;j--)
         {
             newsFeeds.add(new NewsFeed(postList.get(j), j) );
         }
     }

    }


    // add the post to newsFeed
    public  PriorityQueue<NewsFeed> allNewsFeed()
    {
        return newsFeeds;
    }





}
