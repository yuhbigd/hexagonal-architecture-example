package com.port.driver.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class GetCustomerDto {
    private int id;
    private String name;
    private String email;
}
