package com.practice.Database;


import com.practice.Entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Owned by Naufal Muhammad Ischyros
 */

public class CustomerData {
    private static SessionFactory factory = new HibernateConfiguration().getSessionFactory();

    private static Session sesn = factory.openSession();

    public Boolean addCustomer(Customer customer) {
        try {
            sesn.save(customer);
        } finally {

        } return true;
    }
}
