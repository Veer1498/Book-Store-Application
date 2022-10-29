package com.bridgelabz.bookstoreapp.service;

import com.bridgelabz.bookstoreapp.dto.UserDto;
import com.bridgelabz.bookstoreapp.dto.UserLoginDto;
import com.bridgelabz.bookstoreapp.model.User;
import com.bridgelabz.bookstoreapp.repository.UserRepo;
import com.bridgelabz.bookstoreapp.utilities.MailService;
import com.bridgelabz.bookstoreapp.utilities.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/**
 * Purpose : This Application is to control User and Book Services.
 * Author : Veer
 */
@Service
public class UserService implements IUserService{

    @Autowired
    UserRepo repository;

    @Autowired
    TokenUtil tokenUtil;

    @Autowired
    MailService mailService;

    @Override
    public String addRecord(UserDto userDto) {
        User user = new User(userDto);
        repository.save(user);
        String token = tokenUtil.createToken(user.getId());
        mailService.sendEmail(user.getEmailId(), "Account Successfully Created",user.toString());
        return token;
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User FindById(int id) {
        Optional<User> user = repository.findById(id);
        if(user.isPresent())
            return user.get();
        return null;
    }

    @Override
    public User loginUser(UserLoginDto loginDTO) {
        Optional<User> userDetails = Optional.ofNullable(repository.findByEmail(loginDTO.getEmailId()));
        if (userDetails.isPresent()) {
            if (userDetails.get().getPassword().equals(loginDTO.getPassword())) {
                return userDetails.get();
            }
        }
        return null;
    }

    @Override
    public String resetPassword(UserLoginDto loginDTO) {
        Optional<User> userDetails = Optional.ofNullable(repository.findByEmail(loginDTO.getEmailId()));
        String password = loginDTO.getPassword();
        if(userDetails.isPresent()){
            userDetails.get().setPassword(password);
            mailService.sendEmail(userDetails.get().getEmailId(), "Password has Changed",userDetails.toString());
            return userDetails.toString();
        }
        return null;
    }

    @Override
    public User verifyUser(String token) {
        int userid = tokenUtil.decodeJWT(token);
        Optional<User> user = repository.findById(userid);
        if (user.isPresent()) {
            return user.get();
        }
        return null;
    }

}
