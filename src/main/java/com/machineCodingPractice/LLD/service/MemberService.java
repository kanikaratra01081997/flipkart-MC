package com.machineCodingPractice.LLD.service;

import com.machineCodingPractice.LLD.Repo.MemberRepo;
import com.machineCodingPractice.LLD.exceptions.NoMemberPresent;
import com.machineCodingPractice.LLD.model.Comment;
import com.machineCodingPractice.LLD.model.Member;
import com.machineCodingPractice.LLD.model.Post;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class MemberService {



    MemberRepo memberRepo ;


    public MemberService(MemberRepo memberRepo)
    {
        this.memberRepo = memberRepo;
    }

    public void addPostToMemberPostList(Post post , Integer id)
    {
        //check member if present
        if( !memberRepo.allMembers().containsKey(id))
        {
           throw new NoMemberPresent("member not present post can not be created");
        }

        memberRepo.getMemberCorrespondingToId(id).createPost(post);
        log.info("post created and added to member post list successfully");
    }



    public void addLikesToPost(Post post)
    {
        post.addLike();
        log.info(" post like added " + post.totalLikes);
    }


    public void addDislikePost(Post post)
    {
        post.addDisLike();
        log.info("post dislike added "+ post.disLikes);
    }


    public void addCommentToPost(Post post, Comment comment) {

      // a comment can be created only if member is present ;
        post.addComment(comment);
    }







}
