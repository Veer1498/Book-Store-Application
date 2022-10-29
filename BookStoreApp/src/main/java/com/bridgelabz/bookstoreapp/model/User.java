package com.bridgelabz.bookstoreapp.model;

import com.bridgelabz.bookstoreapp.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
/**
 * Purpose : This Application is to control User and Book Services.
 * Author : Veer
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String firstName;
    private String lastName;
    private String emailId;
    private LocalDate DOB;
    private String password;

    public User(UserDto addressDto) {
        this.firstName = addressDto.getFirstName();
        this.lastName = addressDto.getLastName();
        this.emailId = addressDto.getEmailId();
        this.DOB = addressDto.getDOB();
        this.password = addressDto.getPassword();
    }
}
