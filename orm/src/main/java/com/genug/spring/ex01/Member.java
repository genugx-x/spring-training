package com.genug.spring.ex01;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="MEMBER")
public class Member {
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name ="NAME")
    private String name;

    // 매핑 정보가 없는 필드 - 자동으로 DB와 매핑됨
    private Integer age;

}
