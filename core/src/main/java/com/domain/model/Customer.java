package com.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Customer {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String password;
}
