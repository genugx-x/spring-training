package com.genug.spring.logger.level1.level2;

import com.genug.logger.level1.level2.level3.Level3;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Level2 {

    @Autowired
    private Level3 level3;

    public void test() {
        log.warn("Level2 --- test");
    }

    public void deepTest() {
        log.warn("Level2 --- deepTest");
        level3.deepTest();
    }

}
