package com.bridgelabz.bookstoreapp.controller;

import com.bridgelabz.bookstoreapp.dto.ResponseDto;
import com.bridgelabz.bookstoreapp.dto.UserDto;
import com.bridgelabz.bookstoreapp.dto.UserLoginDto;
import com.bridgelabz.bookstoreapp.model.User;
import com.bridgelabz.bookstoreapp.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * Purpose : This Application is to control User and Book Services.
 * Author : Veer
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> AddAddressDetails( @RequestBody UserDto userDto) {
        String token = userService.addRecord(userDto);
        ResponseDto respDTO = new ResponseDto("Data Added Successfully", token);
        return new ResponseEntity(respDTO, HttpStatus.CREATED);
    }

    // Get all user data
    @GetMapping("/findAll")
    public ResponseEntity<ResponseDto> findAllDetail() {
        List<User> userList = userService.findAll();
        ResponseDto responseDTO = new ResponseDto("** All User List ** ", userList);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    //Get user by id
    @GetMapping("/get/{Id}")
    public ResponseEntity<ResponseDto> FindById(@PathVariable int Id) {
        User response = userService.FindById(Id);
        ResponseDto responseDto = new ResponseDto("***All Details user list using Id***", response);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
    //User login
    @PostMapping("/login")
    public ResponseEntity<ResponseDto> loginUser(@RequestBody UserLoginDto loginDTO) {
        User response = userService.loginUser(loginDTO);
        ResponseDto responseDTO = new ResponseDto("Login Successful!", response);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    // reset password
    @PostMapping("/resetPassword")
    public ResponseEntity<ResponseDto> changePassword(@RequestBody UserLoginDto loginDTO) {
        String response = userService.resetPassword(loginDTO);
        ResponseDto responseDTO = new ResponseDto("Password Changed:", response);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    // verify user by token
    @GetMapping("/verify/{token}")
    public ResponseEntity<ResponseDto> verifyUser(@PathVariable String token) {
        User user =userService.verifyUser(token);
        ResponseDto responseDTO = new ResponseDto("User verified successfully", user);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
