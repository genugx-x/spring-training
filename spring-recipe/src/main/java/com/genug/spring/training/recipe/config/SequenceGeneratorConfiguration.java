package com.genug.spring.training.recipe.config;

import com.genug.spring.training.recipe.sequence.SequenceGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration // 스프링은 해당 어노테이션이 달린 클래스를 보면 @Bean 메서드를 찾는다.
public class SequenceGeneratorConfiguration {

    // 메서드 명과 동일한 이름의 빈을 생성한다. 이름을 지정하는 경우에는 속성 코드 추가
    @Bean
    public SequenceGenerator sequenceGenerator() {
        SequenceGenerator seqgen = new SequenceGenerator();
        seqgen.setPrefix("30");
        seqgen.setSuffix("A");
        seqgen.setInitial(100000);
        return seqgen;
    }
}
