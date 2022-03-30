package com.genug.spring.object.mapper.json;

public class JsonData {
    private String name;
    private Integer age;
    private String mbti;

    public JsonData(String name, Integer age, String mbti) {
        this.name = name;
        this.age = age;
        this.mbti = mbti;
    }
}
