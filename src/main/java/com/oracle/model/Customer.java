package com.oracle.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import jakarta.persistence.Id;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;



@Component //by this annotation the class gets registered as a bean 
@Scope(scopeName = "prototype")
@Entity
@Table(name = "mycustomer1") //ORM framework creates table based on your entity structure
public class Customer {
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Id
	private String email;
	
	//types of Autowired: 1.By type, 2.By name, 3.By constructor (you cant specify the type, it gets determined by itself)
	@Autowired //if there is any bean of type "Account" then it gets wired to this 
	@OneToOne(cascade = CascadeType.PERSIST)
	private Account account;

	public Customer() {
		System.out.println("Customer object created.");
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", account="
				+ account + "]";
	}
	
	
	
	
}
