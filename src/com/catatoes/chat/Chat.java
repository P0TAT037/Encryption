package com.catatoes.chat;

import java.net.InetAddress;
import java.util.Scanner;


public class Chat {
    //TODO: make a GUI
    //TODO: add usernames
    //TODO: check for free ports and choose a random one


    public static void main(String argv[]) {


        Scanner scan = new Scanner(System.in);
        String ss = scan.nextLine();

        if(ss.equalsIgnoreCase("server")){
            try {
                Server s = new Server(22000);
                s.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            try {
                InetAddress localHost = InetAddress.getLocalHost();
                System.out.println("localHost: "+ localHost);
                System.out.print("ip: ");
                String ip = scan.nextLine();
                Client c = new Client(ip, 22000);
                c.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
