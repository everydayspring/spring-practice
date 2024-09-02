package com.example.springpractice.service.organization;

import com.example.springpractice.entity.Organization;
import com.example.springpractice.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {
    private final OrganizationRepository organizationRepository;

    @Override
    public void create(String name, String tel, String businessNumber, String address) {
        organizationRepository.save(new Organization(name, tel, businessNumber, address));
    }

    @Override
    @Transactional(readOnly = true)
    public Organization getOrganization(Long id) {
        return organizationRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Organization not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Organization> getOrganizations(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return organizationRepository.findAll(pageRequest);
    }

    @Override
    public void update(Long id, String name, String tel, String businessNumber, String address) {
        Organization organization = organizationRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Organization not found"));

        organization.update(name, tel, businessNumber, address);
    }

    public void delete(Long id) {
        organizationRepository.deleteById(id);
    }
}
