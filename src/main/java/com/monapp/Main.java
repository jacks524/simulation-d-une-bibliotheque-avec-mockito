package com.monapp;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class Main {
    static Scanner s;

    public static void main(String[] args) {
        System.out.println("Bienvenue dans ma Bibliotheque!\n");
        s = new Scanner(System.in);
        int n = s.nextInt();
        switch (n) {
            case 1:
                login();
                break;
            case 2:
                newuser();
                break;
            default:
                System.out.println("Erreur");

        }
    }

    public static void login() {
        System.out.println("Entrer votre numero de telephone :");
        String phonenumber = s.next();
        System.out.println("Entrer votre email :");
        String email = s.next();
    }

    public static void newuser() {
        System.out.println("Entrer votre nom :");
        String name = s.next();
        System.out.println("Entrer votre numero de telephone :");
        String phonenumber = s.next();
        System.out.println("Entrer votre email :");
        String email = s.next();
        System.out.println("Nouvel utilisateur créé!");
    }
}
