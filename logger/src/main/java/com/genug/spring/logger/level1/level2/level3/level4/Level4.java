package com.genug.spring.logger.level1.level2.level3.level4;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Level4 {

    public void test() {
        log.warn("Level4 --- test");
    }

    public void deepTest() {
        log.info("Level4 --- deepTest");
    }
}
