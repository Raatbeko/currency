package com.example.currency.service;


import com.example.currency.dto.user.request.UserAuthRequest;
import com.example.currency.dto.user.request.UserRequest;
import com.example.currency.dto.user.response.UserResponse;
import com.example.currency.dto.user.response.UserTokenResponse;
import com.example.currency.exception.UserSignInException;

public interface UserService extends BaseService<UserResponse, UserRequest> {

    UserTokenResponse getToken(UserAuthRequest request) throws UserSignInException;
}
