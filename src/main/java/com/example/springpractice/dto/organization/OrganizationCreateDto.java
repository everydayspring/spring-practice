package com.example.springpractice.dto.organization;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class OrganizationCreateDto {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request {
        @NotBlank
        private String name;
        @NotBlank
        private String tel;
        @NotBlank
        private String businessNumber;
        @NotBlank
        private String address;
    }
}
