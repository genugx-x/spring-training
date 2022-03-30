package com.genug.spring.logger.level1;

import com.genug.logger.level1.level2.Level2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Level1 {

    @Autowired
    private Level2 level2;

    public void test() {
        log.error("Level1 --- test");
    }

    public void deepTest() {
        log.error("Level1 --- deepTest");
        level2.deepTest();
    }

}
