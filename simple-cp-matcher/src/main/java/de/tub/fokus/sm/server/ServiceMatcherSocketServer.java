package de.tub.fokus.sm.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServiceMatcherSocketServer {
    public static void main(String[] args) throws IOException {
        
        if (args.length != 1) {
            System.err.println("Usage: java ServiceMatcherSocketServer <port number>");
            System.exit(1);
        }

        int portNumber = Integer.parseInt(args[0]);

        try { 
            ServerSocket serverSocket = new ServerSocket(portNumber);
            Socket clientSocket = serverSocket.accept();
            PrintWriter out =
                new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));

            String inputLine, outputLine;
            
            // Initiate conversation with client
            ServiceMatchingProtocol smp = new ServiceMatchingProtocol();
            outputLine = smp.processInput(null);
            out.println(outputLine);

            while ((inputLine = in.readLine()) != null) {
                outputLine = smp.processInput(inputLine);
                out.println(outputLine);
                if (outputLine.equals("SOCKET CLOSED."))
                    break;
            }
            
            serverSocket.close();
            
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}