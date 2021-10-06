package com.example.bankservices.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDto {

    private Long id;
    private String name;
    private String surname;
    private LocalDate birthdate;
    private String address;

}
