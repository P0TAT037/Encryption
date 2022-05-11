package com.catatoes.chat;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

public class Client extends NetworkDevice{

    Client(String ip, int port) throws Exception {

        communicationSocket = new Socket(ip, port);

        socketReader = new BufferedReader(new InputStreamReader(communicationSocket.getInputStream()));
        socketWriter = new DataOutputStream(communicationSocket.getOutputStream());

        receive();
        send();
    }

}
