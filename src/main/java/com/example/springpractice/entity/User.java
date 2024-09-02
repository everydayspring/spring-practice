package com.example.springpractice.entity;

import com.example.springpractice.support.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "organization_id")
    private Organization organization;

    private String loginId;

    private String password;

    private String name;

    // yyyy-mm-dd
    private LocalDate birth;

    private int age;

    private String address;

    private String mobile;

    public User(Organization organization, String loginId, String password, String name, LocalDate birth, int age, String address, String mobile) {
        this.organization = organization;
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.birth = birth;
        this.age = age;
        this.address = address;
        this.mobile = mobile;
    }
}
