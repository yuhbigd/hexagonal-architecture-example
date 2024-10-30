package com.port.driver;

import com.port.driver.dto.CreateCustomerDto;
import com.port.driver.dto.GetCustomerDto;
import com.port.driver.dto.UpdateCustomerDto;

public interface ICrudCustomer {
    GetCustomerDto getCustomer(int id);

    void createCustomer(CreateCustomerDto createCustomerDto);

    void updateCustomer(int id, UpdateCustomerDto updateCustomerDto);

    void deleteCustomer(int id);
}
