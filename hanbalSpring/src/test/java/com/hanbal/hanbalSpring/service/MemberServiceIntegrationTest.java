package com.hanbal.hanbalSpring.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import com.hanbal.hanbalSpring.domain.Member;
import com.hanbal.hanbalSpring.repository.MemberRepository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
@Transactional
public class MemberServiceIntegrationTest {
    
    @Autowired
    MemberService memberService;
    
    @Autowired
    MemberRepository memoryMemberRepository;

    @Test
    void join(){
        //given
        Member member = new Member();
        member.setName("hello");
        
        // when
        Long saveId = memberService.join(member);
        
        //then
        Member findMember = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
        

    }

    @Test
    public void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("스프링1");

        Member member2 = new Member();
        member2.setName("스프링1");

        //when
        memberService.join(member1);

        //try catch 대신 사용
        assertThrows(IllegalStateException.class,() -> memberService.join(member2));
        
        // try{
        //     memberService.join(member2);
        //     //fail();
        // }catch(IllegalStateException e){
        //     Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        // }

    }
}
