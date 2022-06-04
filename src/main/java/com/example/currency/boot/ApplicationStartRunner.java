package com.example.currency.boot;

import com.example.currency.dto.user.request.UserRequest;
import com.example.currency.entity.RoleEntity;
import com.example.currency.entity.UserRoleEntity;
import com.example.currency.repository.RoleRepository;
import com.example.currency.repository.UserRepository;
import com.example.currency.repository.UserRoleRepository;
import com.example.currency.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ApplicationStartRunner implements CommandLineRunner {
    final UserService userService;
    final UserRepository userRepository;
    final RoleRepository roleRepository;
    final UserRoleRepository userRoleRepository;

    @Override
    public void run(String... args) {
        userRoleRepository.save(UserRoleEntity.builder()
                .role(roleRepository.findByRole("ADMIN"))
                .user(userRepository.findByUserNameAndEMail("raatbeko")).build());
    }

}
