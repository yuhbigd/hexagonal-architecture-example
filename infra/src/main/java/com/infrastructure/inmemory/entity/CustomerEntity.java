package com.infrastructure.inmemory.entity;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerEntity {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String password;
    private LocalDate createdDate;
}
