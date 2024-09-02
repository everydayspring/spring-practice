package com.example.springpractice.service.organization;

import com.example.springpractice.entity.Organization;
import org.springframework.data.domain.Page;

public interface OrganizationService {
    void create(String name, String tel, String businessNumber, String address);

    Organization getOrganization(Long id);

    Page<Organization> getOrganizations(int page, int size);

    void update(Long id, String name, String tel, String businessNumber, String address);

    void delete(Long id);
}
