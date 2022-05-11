package com.catatoes.chat;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class NetworkDevice {
    Socket communicationSocket;
    BufferedReader socketReader;
    DataOutputStream socketWriter;

    void send() throws Exception {
        Scanner scan = new Scanner(System.in);
        while (true){
            String message = scan.nextLine();
            this.socketWriter.writeBytes(message+'\n');
        }
    }

    void receive() {
        new Thread(()-> {
            while(true){
                try {
                    System.out.println(socketReader.readLine());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    void disconnect() throws Exception {
        this.socketReader.close();
        this.socketWriter.close();
        this.communicationSocket.close();
    }
}
