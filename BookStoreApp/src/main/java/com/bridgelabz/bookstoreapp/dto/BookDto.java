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
public class BookDto {
    private String bookName;
    private String bookAuthor;
    private String bookDesc;
    private int bookPrice;
    private int bookQuantity;
}
