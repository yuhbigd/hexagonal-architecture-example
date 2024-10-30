package com.driver.adapter.rest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.port.driver.ICrudCustomer;
import com.port.driver.dto.CreateCustomerDto;
import com.port.driver.dto.GetCustomerDto;
import com.port.driver.dto.UpdateCustomerDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerController {
    private final ICrudCustomer crudCustomer;

    @GetMapping
    public GetCustomerDto getCustomer(Integer id) {
        return crudCustomer.getCustomer(id);
    }

    @PostMapping
    public void createCustomer(@RequestBody CreateCustomerDto createCustomerDto) {
        crudCustomer.createCustomer(createCustomerDto);
    }

    @PutMapping("/{id}")
    public void updateCustomer(@PathVariable Integer id, @RequestBody UpdateCustomerDto updateCustomerDto) {
        crudCustomer.updateCustomer(id, updateCustomerDto);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Integer id) {
        crudCustomer.deleteCustomer(id);
    }
}
