package com.practice.Database;

import com.practice.Entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Owned by Naufal Muhammad Ischyros
 */

public class HibernateConfiguration {
    private static SessionFactory factory = null;
    private static StandardServiceRegistry serviceRegistry = null;

    public SessionFactory getSessionFactory(){
        if (factory == null){
            try {
                Configuration config = new Configuration();
                config.configure();
                config.addAnnotatedClass(Customer.class);
                config.addAnnotatedClass(Account.class);
                config.addAnnotatedClass(Wallet.class);
                config.addAnnotatedClass(Transaction.class);
                config.addAnnotatedClass(WalletAccount.class);
                config.addAnnotatedClass(TransactionType.class);
//                config.addResource("query.hbm.xml");
                serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
                factory = config.buildSessionFactory(serviceRegistry);
            } catch (Exception e){
                e.printStackTrace();
            }
        } return factory;
    }
}
