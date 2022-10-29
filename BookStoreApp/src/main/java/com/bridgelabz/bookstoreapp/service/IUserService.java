package com.bridgelabz.bookstoreapp.service;

import com.bridgelabz.bookstoreapp.dto.UserDto;
import com.bridgelabz.bookstoreapp.dto.UserLoginDto;
import com.bridgelabz.bookstoreapp.model.User;

import java.util.List;
/**
 * Purpose : This Application is to control User and Book Services.
 * Author : Veer
 */
public interface IUserService {
    String addRecord(UserDto addressDto);

    List<User> findAll();

    User FindById(int id);

    User loginUser(UserLoginDto loginDTO);

    String resetPassword(UserLoginDto loginDTO);

    User verifyUser(String token);
}
