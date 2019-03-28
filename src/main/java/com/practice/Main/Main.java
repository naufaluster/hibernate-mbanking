package com.practice.Main;

import com.practice.Implements.CustomerImpl;
import com.practice.Interface.ICustomer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static com.practice.ErrorMenu.WrongInput.errorStartMenu;
import static com.practice.StartMenu.Register.insertDataCustomer;

/**
 * Owned by Naufal Muhammad Ischyros
 */
public class Main {

    public static ICustomer iCustomer = new CustomerImpl();

    static InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    static BufferedReader input = new BufferedReader(inputStreamReader);


    public static void main(String[] args) {
        startMenu();
    }

    public static void startMenu(){
        System.out.println("\n========= Tensai =========");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("0. Exit");
        System.out.println("");
        System.out.print("Enter choice> ");

            try {
                String startmenu = input.readLine();

                switch (startmenu){
                    case "0":
                        System.out.println("Thank you for banking with us!");
                        System.exit(0);
                        break;

                    case "1":
                        insertDataCustomer();
                        startMenu();
                        break;
                    default:
                        System.out.println();
                        System.out.println("Wrong choice, please input the right choice!");
                        errorStartMenu();
                        break;
                }
            } catch (Exception e){
                e.printStackTrace();
            }


    }

}
