package com.hanbal.hanbalSpring.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import com.hanbal.hanbalSpring.domain.Member;

public class JpaMemberRepository implements MemberRepository{

    /* JPA는 EntityManger로 동작함 */
    private final EntityManager em;

    public JpaMemberRepository(EntityManager em){
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        List <Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class).setParameter("name", name).getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        List<Member> result = 
            em.createQuery("select m from Member m", Member.class).getResultList(); /* Table이 아닌 Entity를 대상으로 조회 객체 자체로 조회하기 때문에 * 말고 m으로...*/
        return result;
    }
}
