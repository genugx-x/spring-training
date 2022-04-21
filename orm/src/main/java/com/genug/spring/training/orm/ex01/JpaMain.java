package com.genug.spring.training.orm.ex01;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

@Slf4j
@Component
public class JpaMain {

    public static void main (String[] args) {
        log.info("JpaRunner run...");

        // 엔티티 매니저 팩토리 - 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        // 엔티티 매니저 - 생성
        EntityManager em = emf.createEntityManager();
        // 트랜잭션 - 획득
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            logic(em);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();

    }

    // 비즈니스 로직
    private static void logic(EntityManager em) {
        String id = "id3";
        Member member = new Member();
        member.setId(id);
        member.setName("WooJoo");
        member.setAge(36);

        // 등록
        em.persist(member);

        Member findMember = em.find(Member.class, id);
        log.info("{}", findMember);

        // 수정
        member.setAge(13);

        // JPQL (Persistence Query Language) - 엔티티 객체(클래스와 필드)를 대상으로 쿼리
        // SQL - 데이터베이스 테이블을 대상으로 쿼리
        List<Member> members = em
                .createQuery("select m from Member m", Member.class)
                //                  ↑ JPQL - 회원 엔티티 객체를 의미, DB의 MEMBER 테이블이 아니다.
                .getResultList();
        log.info("{}", members);
        // JPQL은 DB 테이블을 전혀 알지 못한다.

        em.remove(member);
    }
}
