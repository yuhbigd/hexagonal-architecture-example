package com.infrastructure.inmemory;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.domain.model.Customer;
import com.infrastructure.exception.IdNotFoundException;
import com.infrastructure.inmemory.entity.CustomerEntity;
import com.port.driven.CustomerRepository;

import jakarta.annotation.PostConstruct;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    private final Map<Integer, CustomerEntity> customerMap = new HashMap<>();

    @PostConstruct
    public void init() {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId(1);
        customerEntity.setName("John Doe");
        customerEntity.setEmail("abc@gmail.com");
        customerEntity.setPhone("1234567890");
        customerEntity.setAddress("123, ABC Street, XYZ City");
        customerEntity.setPassword("password");
        customerEntity.setCreatedDate(java.time.LocalDate.now());
        customerMap.put(customerEntity.getId(), customerEntity);
    }

    @Override
    public Customer getCustomer(int id) {
        CustomerEntity customerEntity = customerMap.get(id);
        if (customerEntity == null) {
            throw new IdNotFoundException("Customer with id " + id + " not found");
        }
        Customer customer = Customer.builder().id(customerEntity.getId()).name(customerEntity.getName())
                .email(customerEntity.getEmail()).phone(customerEntity.getPhone()).address(customerEntity.getAddress())
                .password(customerEntity.getPassword()).build();
        return customer;
    }

    @Override
    public void createCustomer(Customer customer) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId(customerMap.size() + 1);
        customerEntity.setName(customer.getName());
        customerEntity.setEmail(customer.getEmail());
        customerEntity.setPhone(customer.getPhone());
        customerEntity.setAddress(customer.getAddress());
        customerEntity.setPassword(customer.getPassword());
        customerEntity.setCreatedDate(java.time.LocalDate.now());
        customerMap.put(customerEntity.getId(), customerEntity);
    }

    @Override
    public void updateCustomer(int id, Customer customer) {
        CustomerEntity customerEntity = customerMap.get(id);
        if (customerEntity == null) {
            throw new IdNotFoundException("Customer with id " + id + " not found");
        }
        customerEntity.setName(customer.getName());
        customerEntity.setEmail(customer.getEmail());
        customerEntity.setPhone(customer.getPhone());
        customerEntity.setAddress(customer.getAddress());
        customerEntity.setPassword(customer.getPassword());
        customerMap.put(customerEntity.getId(), customerEntity);
    }

    @Override
    public void deleteCustomer(int id) {
        CustomerEntity customerEntity = customerMap.get(id);
        if (customerEntity == null) {
            throw new IdNotFoundException("Customer with id " + id + " not found");
        }
        customerMap.remove(id);
    }

}
