package com.machineCodingPractice.LLD.Repo;

import com.machineCodingPractice.LLD.exceptions.MemberAlreadyPresent;
import com.machineCodingPractice.LLD.exceptions.NoMemberPresent;
import com.machineCodingPractice.LLD.model.Member;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@Log4j2
public class MemberRepo {

    public static  HashMap<Integer,Member> members = new HashMap<>();


    public void addMember(Integer id, Member member)
    {
        if(members.containsKey(id))
        {
            log.error("member already present");
            throw new MemberAlreadyPresent("member already present try to create with new Id");
        }

        members.put(id, member);
        log.info("member added successfully");

    }


    public Member getMemberCorrespondingToId(Integer id)
    {
        if(!members.containsKey(id))
        {
            throw  new NoMemberPresent("member Not present");
        }
        return members.get(id);
    }


    public HashMap<Integer,Member> allMembers()
    {
        log.info("all members returned " , members);
        return  members;
    }



    public boolean memberPresent(Integer id)
    {
        return members.containsKey(id);
    }



}
