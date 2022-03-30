package com.genug.spring.jpa.application;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
public class TestService {

    @Autowired
    private TestRepository repository;

    @Transactional
    public void save() {
        Test test = Test.builder()
                .name("A")
                .data("A")
                .build();
        repository.save(test);
        Test test2 = Test.builder()
                .name("B")
                .data("B")
                .build();
        repository.save(test2);
        log.info("test A (insert) ----> {}", test);
        log.info("test B (insert) ----> {}", test2);
    }

    @Transactional
    public void update1() {
        Test test = repository.findById(1L).orElse(null);
        test.setData("F");
        repository.save(test);
    }

    @Transactional
    public void update2() {
        Test test = repository.findById(2L).orElse(null);
        test.setName("X");
    }

    public List<Test> printTests() {
        List<Test> tests = repository.findAll();
        tests.forEach( test -> {
            log.info("{}", test);
        });
        return tests;
    }
}
