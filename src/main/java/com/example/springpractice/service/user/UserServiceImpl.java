package com.example.springpractice.service.user;

import com.example.springpractice.entity.Organization;
import com.example.springpractice.entity.User;
import com.example.springpractice.repository.OrganizationRepository;
import com.example.springpractice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final OrganizationRepository organizationRepository;
    private final UserRepository userRepository;
    @Override
    public void create(Long organizationId, String loginId, String password, String name, LocalDate birth, int age, String address, String mobile) {
        Organization organization = organizationRepository.findById(organizationId).orElseThrow(
                () -> new IllegalArgumentException("Organization not found")
        );

        User user = userRepository.save(new User(organization, loginId, password, name, birth, age, address, mobile));

        organization.addUser(user);
    }
}
