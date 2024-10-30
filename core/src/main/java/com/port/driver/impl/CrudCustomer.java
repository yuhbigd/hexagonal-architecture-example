package com.port.driver.impl;

import com.common.UseCase;
import com.domain.model.Customer;
import com.port.driven.CustomerRepository;
import com.port.driver.ICrudCustomer;
import com.port.driver.dto.CreateCustomerDto;
import com.port.driver.dto.GetCustomerDto;
import com.port.driver.dto.UpdateCustomerDto;

import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class CrudCustomer implements ICrudCustomer {
    private final CustomerRepository customerRepository;

    @Override
    public GetCustomerDto getCustomer(int id) {
        Customer customer = customerRepository.getCustomer(id);
        return new GetCustomerDto(customer.getId(), customer.getName(), customer.getEmail());
    }

    @Override
    public void createCustomer(CreateCustomerDto createCustomerDto) {
        Customer customer = Customer.builder().name(createCustomerDto.getName()).email(createCustomerDto.getEmail())
                .phone(createCustomerDto.getPhone()).address(createCustomerDto.getAddress())
                .password(createCustomerDto.getPassword()).build();
        customerRepository.createCustomer(customer);
    }

    @Override
    public void updateCustomer(int id, UpdateCustomerDto updateCustomerDto) {
        Customer customer = Customer.builder().name(updateCustomerDto.getName()).email(updateCustomerDto.getEmail())
                .phone(updateCustomerDto.getPhone()).address(updateCustomerDto.getAddress())
                .password(updateCustomerDto.getPassword()).build();
        customerRepository.updateCustomer(id, customer);
    }

    @Override
    public void deleteCustomer(int id) {
        customerRepository.deleteCustomer(id);
    }

}
