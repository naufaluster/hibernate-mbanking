package com.practice.Implements;

import com.practice.Database.CustomerData;
import com.practice.Entity.Customer;
import com.practice.Interface.iCustomer;

/**
 * Owned by Naufal Muhammad Ischyros
 */
public class CustomerImpl implements iCustomer {

    private CustomerData customerData = new CustomerData();

    public Boolean addCustomer(Customer customer) {
        return customerData.addCustomer(customer);
    }
}
