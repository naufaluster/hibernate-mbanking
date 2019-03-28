package com.practice.Database;


import com.practice.Entity.Customer;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Owned by Naufal Muhammad Ischyros
 */

public class CustomerData {

    static SessionFactory sfactory;
    static Session seson;

    private static SessionFactory buildSessionFactory() {
        // Creating Configuration Instance & Passing Hibernate Configuration File
        Configuration configObj = new Configuration();
        configObj.configure("hibernate.cfg.xml");
        configObj.addAnnotatedClass(Customer.class);
        // Since Hibernate Version 4.x, ServiceRegistry Is Being Used
        ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder()
                .applySettings(configObj.getProperties()).build();

        // Creating Hibernate SessionFactory Instance
        sfactory = configObj.buildSessionFactory(serviceRegistryObj);
        return sfactory;
    }

    public Boolean addCustomer(Customer customer) {
            Customer cust = new Customer();

            try{
                Session sesn = sfactory.openSession();
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
