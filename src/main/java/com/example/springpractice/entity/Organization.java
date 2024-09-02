package com.example.springpractice.entity;

import com.example.springpractice.support.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.util.Strings;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Organization extends BaseEntity {
    private String name;

    // 02-1234-1232
    private String tel;

    // 02-456246-45676
    private String businessNumber;

    private String address;

    @OneToMany(mappedBy = "organization", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<User> users = new ArrayList<>();

    public Organization(String name, String tel, String businessNumber, String address) {
        if (Strings.isBlank(name)) {
            throw new IllegalArgumentException("Name cannot be blank.");
        }

        if (Strings.isBlank(tel)) {
            throw new IllegalArgumentException("Tel cannot be blank.");
        }

        if (Strings.isBlank(businessNumber)) {
            throw new IllegalArgumentException("Business Number cannot be blank.");
        }

        if (Strings.isBlank(address)) {
            throw new IllegalArgumentException("Address cannot be blank.");
        }

        this.name = name;
        this.tel = tel;
        this.businessNumber = businessNumber;
        this.address = address;
    }

    public void update(String name, String tel, String businessNumber, String address) {
        if (Strings.isBlank(name)) {
            throw new IllegalArgumentException("Name cannot be blank.");
        }
        if (Strings.isBlank(tel)) {
            throw new IllegalArgumentException("Tel cannot be blank.");
        }
        if (Strings.isBlank(businessNumber)) {
            throw new IllegalArgumentException("Business Number cannot be blank.");
        }
        if (Strings.isBlank(address)) {
            throw new IllegalArgumentException("Address cannot be blank.");
        }

        this.name = name;
        this.tel = tel;
        this.businessNumber = businessNumber;
        this.address = address;
    }

    public void addUser(User user) {
        this.users.add(user);
    }
}
