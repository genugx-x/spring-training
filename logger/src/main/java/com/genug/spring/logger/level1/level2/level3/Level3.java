package com.genug.spring.logger.level1.level2.level3;

import com.genug.logger.level1.level2.level3.level4.Level4;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Level3 {

    @Autowired
    private Level4 level4;

    public void test() {
        log.warn("Level3 --- test");
    }

    public void deepTest() {
        log.info("Level3 --- deepTest");
        level4.deepTest();
    }

}
