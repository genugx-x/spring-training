package com.genug.spring.ex01;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Slf4j
@Component
public class JpaRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
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
        // String id = "1";
        Member member = new Member();
        // member.setId(1L);
        member.setId("id1");
        member.setName("SeongBeom");
        member.setAge(33);

        // 등록
        em.persist(member);

        // 수정
        member.setAge(23);


        Member findMember = em.find(Member.class, member.getId());
        log.info("{}", findMember);

        log.info("????");
        List<Member> members = em.createQuery("select m from Member m", Member.class).getResultList();
        log.info("{}", members);

        // em.remove(member);
    }
}
