package com.genug.spring.ex01;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="MEMBER")
public class Member {

    @Id
    private String id;

    @Column(name ="NAME")
    private String name;

    // 매핑 정보가 없는 필드 - 자동으로 DB와 매핑됨
    private Integer age;
}
