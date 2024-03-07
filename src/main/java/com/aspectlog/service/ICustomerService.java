package com.aspectlog.service;

import java.util.List;

public interface ICustomerService<Customer> {
    List<Customer> findAll() throws Exception;

    void save(Customer t);

    Customer findById(Long id);
    Customer findOne(Long id) throws Exception;

    void remove(Long id);
}
