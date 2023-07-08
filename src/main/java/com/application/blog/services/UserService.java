package com.application.blog.services;

import com.application.blog.payloads.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto user);
    UserDto updateUser(UserDto user, Integer userId);
    UserDto getUserById(Integer UserId);
    List<UserDto> getAllUsers();
    void deleteUser(Integer userId);

}
