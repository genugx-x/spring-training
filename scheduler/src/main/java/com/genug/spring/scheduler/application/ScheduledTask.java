package com.genug.spring.scheduler.application;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
@Component
public class ScheduledTask {

    static int n = 0;

    @Scheduled(fixedRate = 5000)
    void test() throws UnknownHostException {
        n++;
        log.info("Scheduled test ---- {}", n);
    }
}
