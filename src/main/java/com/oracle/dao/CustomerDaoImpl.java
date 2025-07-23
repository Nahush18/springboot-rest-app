package com.oracle.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.oracle.model.Customer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class CustomerDaoImpl implements CustomerDao{
	
	//Entity Manager: one who is responsible for managing entities, ie for creating new entities, deleting, updating, reading basically CRUD operations
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional //this takes care of beginning the transaction as well as commiting the transaction
	public void createCustomer(Customer cust) {
			entityManager.persist(cust); //persist: insert a new record
	}

	@Override
	public Customer readCustomerByEmail(String email) {
		return entityManager.find(Customer.class, email); //find: select that record
	}

	@Override
	public List<Customer> readAllCustomers() {
		//JPQL Query- Java Persistent Query Language
		String jpql = "SELECT c FROM Customer c";
		return entityManager.createQuery(jpql, Customer.class).getResultList();
	}
	
	@Override
	@Transactional
	public void updateCustomer(Customer customer) {
	    entityManager.merge(customer);  // updates the record
	}

	@Override
	@Transactional
	public void deleteCustomerById(int id) {
	    Customer cust = entityManager.find(Customer.class, id);
	    if (cust != null) {
	        entityManager.remove(cust);
	    }
	}
	
}
