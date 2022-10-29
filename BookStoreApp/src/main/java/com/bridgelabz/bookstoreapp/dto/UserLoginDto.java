package com.bridgelabz.bookstoreapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * Purpose : This Application is to control User and Book Services.
 * Author : Veer
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginDto {
    private String emailId;
    private String password;
}
