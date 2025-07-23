package com.oracle.model;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import jakarta.persistence.Id;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Component("account1")
@Scope(scopeName = "singleton")
@Primary //Since this bean is primary if there is any confusion this will get configured
@Entity
@Table(name = "myaccount1")
public class Account {
	@Id
	@Column(name =  "acc_id")
	private int accountId;
	@Column(name = "balance")
	private double balance;
	
	public Account() {
		System.out.println("Account object created.");
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", balance=" + balance + "]";
	}

	
	
}
