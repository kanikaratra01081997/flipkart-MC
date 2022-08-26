package com.machineCodingPractice.LLD;

import com.machineCodingPractice.LLD.Repo.MemberRepo;
import com.machineCodingPractice.LLD.constant.AccountStatus;
import com.machineCodingPractice.LLD.exceptions.NoMemberPresent;
import com.machineCodingPractice.LLD.model.Comment;
import com.machineCodingPractice.LLD.model.Member;
import com.machineCodingPractice.LLD.model.Person;
import com.machineCodingPractice.LLD.model.Post;
import com.machineCodingPractice.LLD.service.MemberService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LldApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(LldApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("hello");

        Person p1 = new Person("Kanika", "kanika.com", "7290927009");
        System.out.println("person 1 " + p1);
        Member m1 = new Member("1", "hello", p1, AccountStatus.ACTIVE, 1);

        System.out.println("member 1 with account " + m1);

        MemberRepo memberRepo = new MemberRepo();
        memberRepo.addMember(1, m1);

        MemberService memberService = new MemberService(memberRepo);
        try
        {
            // post created
            Post post1 = new Post(m1,"1", "hello world my first post"  );
            System.out.println("created Post " + post1);

            memberService.addPostToMemberPostList(post1, 1);

            // add like
            memberService.addLikesToPost(post1);

            // add dislike
            memberService.addDislikePost(post1);

            // create comment

            //member 2 cerated
            Member member2= new Member("2", "hello2", p1, AccountStatus.ACTIVE, 2);
            //member 2 added to the database
            memberRepo.addMember(2, member2);

            Comment comment = new Comment("good one ", 1, member2);

            // member 2 creates comment
            memberService.addCommentToPost(post1,comment);

            // follow

            //only if member2 present and added to db
            m1.addFollower(member2);

            // member 3 not id -3 not added -- removal condition throws exception

          if(memberRepo.memberPresent(2))
          {
              m1.removeFollower(member2);
          }


          // post creation
             m1.addPostOfFollowingToNewsFeed();

          // post display
          System.out.println(m1.allNewsFeed());









        }catch (NoMemberPresent e)
        {
          System.out.println("Exception occured ");
        }

        System.out.println("post added to member list as well "+ m1.posts);

















    }
}
