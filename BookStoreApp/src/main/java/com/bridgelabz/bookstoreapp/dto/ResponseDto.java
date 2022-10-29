package com.bridgelabz.bookstoreapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * Purpose : This Application is to control User and Book Services.
 * Author : Veer
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto {
    public String message;
    public Object object;
}
