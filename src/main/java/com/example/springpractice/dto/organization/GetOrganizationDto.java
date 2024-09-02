package com.example.springpractice.dto.organization;

import com.example.springpractice.entity.Organization;
import com.example.springpractice.entity.User;
import lombok.Getter;
import org.hibernate.query.sql.internal.ParameterRecognizerImpl;

import java.time.LocalDate;
import java.util.List;

public class GetOrganizationDto {
    @Getter
    public static class Response {
        private String name;
        private String tel;
        private String businessNumber;
        private String address;
        private List<UserData> users;

        public Response(Organization organization) {
            this.name = organization.getName();
            this.tel = organization.getTel();
            this.businessNumber = organization.getBusinessNumber();
            this.address = organization.getAddress();
            this.users = organization.getUsers().stream().map(UserData::new).toList();
        }
    }

    @Getter
    public static class UserData {
        private String loginId;
        private String password;
        private String name;
        private LocalDate birth;
        private int age;
        private String address;
        private String mobile;

        public UserData(User user) {
            this.loginId = user.getLoginId();
            this.password = user.getPassword();
            this.name = user.getName();
            this.birth = user.getBirth();
            this.age = user.getAge();
            this.address = user.getAddress();
            this.mobile = user.getMobile();
        }
    }
}
