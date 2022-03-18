package com.catatoes;

import java.util.Scanner;

public class Ceaser {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("1:Encrypt\n2:Decrypt");
        int choice = scan.nextInt();
        System.out.print("Text: ");
        String s = scan.next();
        System.out.print("Key: ");
        int key = scan.nextInt();

        if(choice == 1) {
            System.out.println(Encypher(s, key));
        }
        else {
            System.out.println(Decypher(s, key));
        }

    }

    static String Encypher(String s, int key){
        s = s.toLowerCase();
        String c = "";
        for(int i = 0 ; i < s.length(); i++){
             c += (char) (((s.charAt(i) + key-97) % 26)+97);
        }
        return c;
    }


    static String Decypher(String s, int key){
        s = s.toLowerCase();
        String c = "";
        for(int i = 0 ; i < s.length(); i++){
            c += (char) (((s.charAt(i) - key-97) % 26)+97);
        }
        return c;
    }
}

