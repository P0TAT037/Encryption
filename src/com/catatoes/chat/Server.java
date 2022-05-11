package com.catatoes.chat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends NetworkDevice{

    Server(int port) throws Exception{

        ServerSocket server = new ServerSocket(port);
        communicationSocket = server.accept();

        socketReader = new BufferedReader(new InputStreamReader(communicationSocket.getInputStream()));
        socketWriter = new DataOutputStream(communicationSocket.getOutputStream());

        receive();
        send();
    }

}
