package com.catatoes;

import java.util.Scanner;

public class Vigenere {

    static String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        char[][] table = createTable();
        System.out.println("Encryption Table:");
        printTable(table);
        System.out.println();


        System.out.print("Text: ");
        String txt = scan.nextLine();
        txt = txt.toUpperCase();

        System.out.print("Key: ");
        String key = scan.nextLine();
        key = key.toUpperCase();

        while (true) {
            System.out.println("1: Encrypt");
            System.out.println("2: Decrypt");
            String input = scan.next();
            if (input.equals("1")) {
                System.out.println("Encrypted text: " + encrypt(txt, key, table));
                break;
            } else if (input.equals("2")) {
                System.out.println("Decrypted text: " + decrypt(txt, key));
                break;
            }
        }

    }

    private static char[][] createTable() {
        char matrix[][] = new char[26][26];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                matrix[i][j] = alpha.charAt((i + j) % 26);
            }
        }
        return matrix;
    }

    private static String encrypt( String text, String key, char[][] table) {
        String encrypted = "";
        for (int i = 0; i < text.length(); i++) {
            int x = alpha.indexOf(text.charAt(i));
            int y =alpha.indexOf(key.charAt(i%key.length()));
            encrypted += table[x][y];
        }
        return encrypted;
    }

    private static String decrypt( String text, String key) {

        String decrypted = "";

        for(int i = 0; i< text.length(); i++){
            int c = alpha.charAt((text.charAt(i) - key.charAt(i % key.length()) + 26) %26);
            decrypted += (char) c;
        }
        //the way the table was designed implies that the cipher text
        //would be the sum of the plain text chars and the key chars so,
        //it can be decrypted by subtracting the key from the cipher text

        return decrypted;
    }

    private static void printTable(char[][] table) {
        for (int i = 0; i <= 25; i++) {
            for (int j = 0; j <= 25; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
    }

}
