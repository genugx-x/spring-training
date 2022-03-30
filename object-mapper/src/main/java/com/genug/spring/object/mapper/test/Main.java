package com.genug.spring.object.mapper.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(String[] args) {

        Test test = Test.builder()
                .name("asdfasdfasdf")
                .code("asdfasdf923")
                .inner(Inner.builder()
                        .name("adsfkhsdf")
                        .data("asdfkahjsdfl")
                        .build())
                .build();
        try {

            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(test);

            log.info(json);
            System.out.println();

            Test result = objectMapper.readValue(json, Test.class);
            log.info("{}", result);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
