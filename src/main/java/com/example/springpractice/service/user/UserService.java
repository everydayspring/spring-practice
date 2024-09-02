package com.example.springpractice.service.user;

import com.example.springpractice.entity.Organization;

import java.time.LocalDate;

public interface UserService {
    void create(Long organizationId, String loginId, String password, String name, LocalDate birth, int age, String address, String mobile);
}
