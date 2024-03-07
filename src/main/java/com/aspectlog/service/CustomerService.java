package com.aspectlog.service;

import com.aspectlog.model.Customer;
import com.aspectlog.repository.ICustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService implements ICustomerService<Customer>{

    @Autowired
    private ICustomerRepo customerRepo;
    @Override
    public List<Customer> findAll()  {
        return customerRepo.findAll();
    }


    @Override
    public void save(Customer customer) {
        customerRepo.save(customer);

    }
    @Override
    public Customer findOne(Long id) throws Exception {
        Customer customer = new Customer();
        if (customer.getName() == null) {
            throw new Exception("customer not found!");
        }
        return customer;
    }
    @Override
    public Customer findById(Long id) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
