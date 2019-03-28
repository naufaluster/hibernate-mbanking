package com.practice.Entity;

import javax.persistence.*;

/**
 * Owned by Naufal Muhammad Ischyros
 */

@Entity
@Table (name = "wallet")
public class Transaction {

    @Id
    @Column (name = "walletid")
    private String walletid;

    @Column (name = "description")
    private String description;

    @Column (name = "createDate")
    private String createDate;

    @ManyToOne
    @JoinColumn (name = "customerNumber")
    private Customer customer;

    public String getWalletid() {
        return walletid;
    }

    public void setWalletid(String walletid) {
        this.walletid = walletid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
