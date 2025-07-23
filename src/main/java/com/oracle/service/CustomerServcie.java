package com.oracle.service;

import java.util.List;

import com.oracle.model.Customer;

public interface CustomerServcie {
	public void addCustomer(Customer cust);
	public Customer findCustomerByEmail(String email);
	public List<Customer> findAllCustomer();
	public void updateCustomer(Customer cust);          
    public void deleteCustomerById(int id);              
}
