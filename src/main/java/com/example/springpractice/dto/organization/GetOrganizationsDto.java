package com.example.springpractice.dto.organization;

import com.example.springpractice.entity.Organization;
import lombok.Getter;

import java.time.LocalDateTime;

public class GetOrganizationsDto {

    @Getter
    public static class Response {
        private Long id;
        private String name;
        private LocalDateTime createdAt;

        public Response(Organization organization) {
            this.id = organization.getId();
            this.name = organization.getName();
            this.createdAt = organization.getCreatedAt();
        }
    }
}
