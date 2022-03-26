package com.catatoes;

import java.util.Scanner;

public class Ceaser {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Text: ");
        String txt = scan.next();
        System.out.print("Key: ");
        int key = scan.nextInt();

        while (true) {
            System.out.println("1: Encrypt");
            System.out.println("2: Decrypt");
            String input = scan.next();
            if (input.equals("1")) {
                System.out.println("Encrypted text: " + encrypt(txt, key));
                break;
            } else if (input.equals("2")) {
                System.out.println("Decrypted text: " + decrypt(txt, key));
                break;
            }
        }
    }

    static String encrypt(String txt, int key){
        txt = txt.toUpperCase();
        String encryption = "";
        for(int i = 0 ; i < txt.length(); i++){
             encryption += (char) (((txt.charAt(i) + key-97) % 26)+97);
        }
        return encryption;
    }


    static String decrypt(String txt, int key){
        txt = txt.toUpperCase();
        String decryption = "";
        for(int i = 0 ; i < txt.length(); i++){
            decryption += (char) (((txt.charAt(i) - key-97) % 26)+97);
        }
        return decryption;
    }
}

