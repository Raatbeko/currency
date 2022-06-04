package com.example.currency.service.impl;

import com.example.currency.dto.user.request.UserAuthRequest;
import com.example.currency.dto.user.request.UserRequest;
import com.example.currency.dto.user.response.UserResponse;
import com.example.currency.dto.user.response.UserTokenResponse;
import com.example.currency.entity.UserEntity;
import com.example.currency.entity.UserRoleEntity;
import com.example.currency.exception.EmailNotBeEmptyException;
import com.example.currency.exception.UserSignInException;
import com.example.currency.mapper.UserMapper;
import com.example.currency.repository.RoleRepository;
import com.example.currency.repository.UserRepository;
import com.example.currency.repository.UserRoleRepository;
import com.example.currency.service.UserService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Base64;
import java.util.List;


@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    final UserRepository userRepository;

    final RoleRepository roleRepository;

    final PasswordEncoder passwordEncoder;

    final UserRoleRepository userRoleRepository;

    @Override
    public UserResponse save(UserRequest userRequest) {
        if (userRequest.getEmail() == null)
            throw new EmailNotBeEmptyException("email is empty", HttpStatus.valueOf("EMAIL_NOT_BE_EMPTY"));
        UserEntity userEntity = userRepository
                .save(UserEntity.builder()
                        .login(userRequest.getLogin())
                        .email(userRequest.getEmail())
                        .password(passwordEncoder.encode(userRequest.getPassword()))
                        .isActive(true)
                        .build());
        userRoleRepository
                .save(UserRoleEntity.builder()
                        .role(roleRepository.getById(1L))
                        .user(userEntity).build());


        return UserResponse.builder()
                .email(userEntity.getEmail())
                .id(userEntity.getId())
                .login(userEntity.getLogin())
                .build();
    }

    @Override
    public UserTokenResponse getToken(UserAuthRequest request) throws UserSignInException {
        UserEntity userEntity = userRepository.findByUserNameAndEMail(request.getLoginOrEmail());
        boolean isMatches = passwordEncoder.matches(request.getPassword(), userEntity.getPassword());
        if (isMatches) {
            String token = "Basic " + new String(Base64.getEncoder()
                    .encode((userEntity.getLogin() + ":" + request.getPassword()).getBytes()));
            return UserTokenResponse
                    .builder()
                    .userToken(token)
                    .build();
        } else {
            throw new UserSignInException("Неправильный логин или пароль!", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public List<UserResponse> getAll() {
        return UserMapper.INSTANCE.toUsersResponseDto(userRepository.findAll());
    }

    @Override
    public UserResponse findById(Long id) {
        return UserMapper.INSTANCE.toUserResponseDto(userRepository.findById(id).orElse(new UserEntity()));
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

}
