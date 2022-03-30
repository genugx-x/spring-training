package com.genug.spring.logger.application;

import com.genug.spring.logger.level1.Level1;
import com.genug.spring.logger.level1.level2.Level2;
import com.genug.spring.logger.level1.level2.level3.Level3;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Slf4j
@Component
public class Logger implements ApplicationRunner {

    @Autowired
    private Level1 level1;

    @Autowired
    private Level2 level2;

    @Autowired
    private Level3 level3;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.debug("Logger --- run");
        // test();
        deepTest();

        Path path = Paths.get("C:/Users/sb.kang/Documents/GW플랫폼/테스트/서버/TestClient/Gloquad_log.txt");
        List<String> lines = Files.readAllLines(path);
        lines.forEach( line -> {
            log.info("{}", line);
        });
        log.debug("Logger --- exit");
    }

    public void test() {
        log.info("Logger --- test");
        level1.test();
        level2.test();
        level3.test();
    }

    public void deepTest() {
        log.info("Logger --- deepTest");
        level1.deepTest();
    }
}
