package com.genug.spring.training.orm;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity // 기본 생성자 필수
@Table(name="MEMBER")
public class Member {

    @Id
    @Column(name="ID")
    private String id;

    @Column(name="NAME")
    private String name;

    // 매핑 정보가 없는 필드 - 자동으로 DB와 매핑됨
    private Integer age;

    // Enum 매핑
    @Enumerated(EnumType.STRING)
    @Column(name = "role_types")
    private RoleType roleType;

    // 날짜 타입 매핑
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_modified_date")
    private Date lastModifiedDate;

    // 길이 제한이 없는 필드의 경우
    @Lob
    private String description;


}
