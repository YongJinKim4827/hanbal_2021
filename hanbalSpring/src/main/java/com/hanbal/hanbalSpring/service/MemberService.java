package com.hanbal.hanbalSpring.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.hanbal.hanbalSpring.domain.Member;
import com.hanbal.hanbalSpring.repository.MemberRepository;

import org.springframework.stereotype.Service;

@Transactional /* JPA는 항상 트랜잭션이 있어야함!*/
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }
    
    /**
     * 회원가입
     * @param member
     * @return
     */
    public Long join(Member member){
        /* 방법1 */
        // //같은 이름이 있는 중복 회원X
        // Optional<Member> result = memberRepository.findByName(member.getName());
        // //값이 있다면
        // result.ifPresent(m -> {
        //     throw new IllegalStateException("이미 존재하는 회원입니다.");
        // });

        /* 방법2 */
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }
    
    private void validateDuplicateMember(Member member){
        memberRepository.findByName(member.getName())
        .ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    /**
     * 전체 회원 조회
     * @return
     */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

}
