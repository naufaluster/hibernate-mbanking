package com.practice.Database;


import com.practice.Entity.Customer;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Owned by Naufal Muhammad Ischyros
 */

public class CustomerData {

    static CustomerData customerData;

    private static SessionFactory factory = new HibernateConfiguration().getSessionFactory();

    public Boolean addCustomer(Customer customer) {
            Customer cust = new Customer();

            try{
                Session sesn = factory.openSession();
                Query query = sesn.createQuery("FROM customer ORDER BY cif DESC");
                query.setMaxResults(1);
                Customer ocif = (Customer) query.uniqueResult();
                String newCif = "";
                if (ocif.getCif().isEmpty()) {
                    newCif = "CIF00001";
                } else {
                    int lastLength = ocif.getCif().length();
                    String tid = ocif.getCif().substring(5, lastLength);
                    newCif = "CIF00" + String.format("%03d", Integer.parseInt(tid) + 1);
                }
                cust.setCif(newCif);
            Transaction trx = sesn.beginTransaction();
            sesn.save(customer);
            sesn.flush();
            trx.commit();
        } catch (Exception e){
            e.printStackTrace();
        } return true;
    }
}
