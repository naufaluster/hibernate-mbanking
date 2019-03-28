package com.practice.Entity;

import javax.persistence.*;

/**
 * Owned by Naufal Muhammad Ischyros
 */

@Entity
@Table (name = "account")
public class Account {

    @Id
    @Column (name = "AccountNumber")
    private String AccountNumber;

    @Column (name = "AccountName")
    private String AccountName;

    @Column (name = "openDate")
    private String openDate;

    @Column (name = "balance")
    private int balance;

    @ManyToOne
    @JoinColumn (name = "customerNumber")
    private Customer customer;

    public String getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        AccountNumber = accountNumber;
    }

    public String getAccountName() {
        return AccountName;
    }

    public void setAccountName(String accountName) {
        AccountName = accountName;
    }

    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
