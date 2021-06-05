package com.hanbal.hanbalSpring.repository;

import java.util.List;

import com.hanbal.hanbalSpring.domain.Member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    //메서드가 끝날때마다 동작
    //테스트는 서로 의존관계없이 작성이 되어야함(Clear)
    public void afterEach(){
        repository.clearStore();
    }
    @Test
    public void save() {
        Member member = new Member();
        member.setName("Spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        System.out.println("result : " + (result == member));
        Assertions.assertEquals(member, result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("스프링1");
        repository.save(member1);

        Member member2 = new Member();
        member1.setName("스프링2");
        repository.save(member2);
        Member result = repository.findByName("스프링1").get();
        Assertions.assertEquals(member1, result);
        //assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("스프링1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("스프링2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        
    }
}
