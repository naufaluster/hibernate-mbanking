package com.practice.ErrorMenu;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static com.practice.Main.Main.startMenu;

/**
 * Owned by Naufal Muhammad Ischyros
 */
public class WrongInput {

    static InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    static BufferedReader input = new BufferedReader(inputStreamReader);

    public static void errorStartMenu(){
        System.out.println("");
        System.out.println("Enter any key to continue");
        System.out.print("Enter> ");

        try {
            String esm = input.readLine();
            switch (esm) {
                default:
                    startMenu();
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
