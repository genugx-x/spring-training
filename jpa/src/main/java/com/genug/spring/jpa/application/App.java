package com.genug.spring.jpa.application;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class App implements ApplicationRunner {

    @Autowired
    private TestService service;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        service.save();
        service.update1();
        service.update2();
        service.printTests();
    }


}
