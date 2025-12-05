package com.example.example;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "orderform")

public class OrderDataModel {
    @Id
    private String id;
    private String name;
    private int doorno;
    private String street;
    private String city;
    private String district;
    private String state;
    private int pincode;
    private long phone;
    private LocalDate OrderDate=LocalDate.now();
    
}
