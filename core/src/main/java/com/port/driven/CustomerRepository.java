package com.port.driven;

import com.domain.model.Customer;
public interface CustomerRepository {
    Customer getCustomer(int id);

    void createCustomer(Customer customer);

    void updateCustomer(int id, Customer customer);

    void deleteCustomer(int id);
}
