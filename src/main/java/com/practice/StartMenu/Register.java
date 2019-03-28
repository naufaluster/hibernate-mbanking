package com.practice.StartMenu;

import com.practice.Entity.Customer;
import com.practice.Implements.CustomerImpl;
import com.practice.Interface.ICustomer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Owned by Naufal Muhammad Ischyros
 */
public class Register {

    private static ICustomer iCustomer = new CustomerImpl();

    static InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    static BufferedReader input = new BufferedReader(inputStreamReader);
    static Customer customer = new Customer();


    public static void insertDataCustomer(){

        try {

            // register
            System.out.println("\n======== Register Menu ========");

            //Input username password
            System.out.println( "| " + padRight("Input username and password", 10));

            // input username
            System.out.print( "| " + padRight("Input username", 17) + (": "));
            customer.setUsername(input.readLine().trim());

            // input password
            System.out.print( "| " + padRight("Input password", 17) + (": "));
            customer.setPassword(input.readLine().trim());

            System.out.println();

            //Input name
            System.out.println( "| " + padRight("Input Name", 10));

            // input First Name
            System.out.print( "| " + padRight("Input first name", 17) + (": "));
            customer.setFirstname(input.readLine().trim());

            // input Last Name
            System.out.print( "| " + padRight("Input last name", 17) + (": "));
            customer.setLastname(input.readLine().trim());

            System.out.println();

            // warning about birthdate data
            System.out.println( "| " + padRight("Input Birthdate (YYYY/MM/DD)", 10));

            // input year
            System.out.print( "| " + padRight("Input year", 12 ) + (": "));
            String year = input.readLine().trim();

            // input month
            System.out.print( "| " + padRight("Input month", 12 ) + (": "));
            String month = input.readLine().trim();

            // input date
            System.out.print( "| " + padRight("Input date", 12 ) + (": "));
            String date = input.readLine().trim();

            //Input Birthdate
            customer.setBirthdate(year + month + date);

            iCustomer.addCustomer(customer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String padRight(String text, int l) {
        return String.format("%1$-" + l + "s", text);
    }

}
