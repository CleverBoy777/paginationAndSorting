package com.example.paginationandsortingwithspringdatajpa.payload;

import lombok.Data;



@Data
public class ProductDto {


    private String name;

    private int quantity;

    private long price;
}
