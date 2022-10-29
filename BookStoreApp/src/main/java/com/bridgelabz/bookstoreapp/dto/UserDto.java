package com.bridgelabz.bookstoreapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
/**
 * Purpose : This Application is to control User and Book Services.
 * Author : Veer
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String firstName;
    private String lastName;
    private String emailId;
    @JsonFormat(pattern = "dd MMM yyyy")
    private LocalDate DOB;
    private String password;
}
