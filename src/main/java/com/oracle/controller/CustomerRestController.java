package com.oracle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.exceptions.NoSuchCustomerException;
import com.oracle.model.Customer;
import com.oracle.service.CustomerServcie;
import com.oracle.exceptions.*;


@RestController
@RequestMapping(path = "/customer-api/")

public class CustomerRestController {
	
	@Autowired // already a bean so needs autowiring
	private CustomerServcie service;
	//http://localhost:8080/customer-api
	
	@PostMapping  //will help us customize an http URL
	public ResponseEntity<String> addCustomer(@RequestBody Customer cust) {
		service.addCustomer(cust);
		ResponseEntity<String> response = new ResponseEntity<String>("Customer added Successfully!", HttpStatus.CREATED);
		return response;
	}
	
	// http://localhost:8080/customer-api
	@GetMapping
	public List<Customer> getAllCustomers() {
	    return service.findAllCustomer();
	}
	
	//http://localhost:8080/customer-api/email/jsnow2@gmail.com
	//http://localhost:8080/customer-api/email?emailId=jsnow2@gmail.com
	@GetMapping(path="/email/{emailId}")
	public Customer getCustomerByEmail(@PathVariable("emailId") String email) {
		return service.findCustomerByEmail(email);
	}
	
	@PutMapping
    public String updateCustomer(@RequestBody Customer cust) {
        service.updateCustomer(cust);
        return "Customer updated.";
    }
	
	@DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable int id) {
        service.deleteCustomerById(id);
        return "Customer deleted.";
    }
	
	@ExceptionHandler(NoSuchCustomerException.class)
	public ResponseEntity<String> handleNoSuchCustomerException(NoSuchCustomerException ex) {
		ResponseEntity<String> response = new ResponseEntity<String>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		return response;
	}
	
	@ExceptionHandler(DuplicateCustomerException.class)
	public ResponseEntity<String> handleDuplicateCustomerException(DuplicateCustomerException ex) {
	    return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT); // 409 Conflict
	}

}



