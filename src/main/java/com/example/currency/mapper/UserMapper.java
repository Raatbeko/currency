package com.example.currency.mapper;


import com.example.currency.dto.user.request.UserAuthRequest;
import com.example.currency.dto.user.request.UserRequest;
import com.example.currency.dto.user.response.UserResponse;
import com.example.currency.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    

    UserResponse toUserResponseDto(UserEntity user);

    List<UserResponse> toUsersResponseDto(List<UserEntity> users);

    UserAuthRequest toUserAuthDto(UserEntity user);

    UserEntity toUserEntity(UserResponse userResponse);

    default void test(UserRequest userRequest){

    }
}