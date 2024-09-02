package com.example.springpractice.controller;

import com.example.springpractice.dto.organization.GetOrganizationDto;
import com.example.springpractice.dto.organization.GetOrganizationsDto;
import com.example.springpractice.dto.organization.OrganizationCreateDto;
import com.example.springpractice.entity.Organization;
import com.example.springpractice.service.organization.OrganizationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/organizations")
public class OrganizationController {
    private final OrganizationService organizationService;

    @PostMapping
    public void create(@RequestBody @Valid OrganizationCreateDto.Request request) {
        organizationService.create(request.getName(), request.getTel(), request.getBusinessNumber(), request.getAddress());
    }

    @GetMapping
    public Page<GetOrganizationsDto.Response> getOrganizations(@RequestParam int page, @RequestParam int size) {
        Page<Organization> results = organizationService.getOrganizations(page, size);

        return results.map(GetOrganizationsDto.Response::new);

    }

    @GetMapping("/{id}")
    public GetOrganizationDto.Response getOrganiation(@PathVariable long id) {
        Organization organization = organizationService.getOrganization(id);

        return new GetOrganizationDto.Response(organization);
    }

    @PatchMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody @Valid OrganizationCreateDto.Request request) {
        organizationService.update(id, request.getName(), request.getTel(), request.getBusinessNumber(), request.getAddress());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        organizationService.delete(id);
    }
}
