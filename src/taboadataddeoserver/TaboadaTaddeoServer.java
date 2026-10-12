/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package taboadataddeoserver;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 *
 * @author taboada.taddeo
 */
public class TaboadaTaddeoServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        int porta = 12345;
        ServerSocket server = new ServerSocket(porta);
        String message;
        Scanner scanner = new Scanner(System.in);
       
        /*
        InputStream inputStream = clientSocket.getInputStream();
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        OutputStream outputStream = clientSocket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        
        // Primo messaggio
        message = "Ciao sono il server di Taddeo!";
        dataOutputStream.writeUTF(message);
        */
       
        while (true) {
            Socket clientSocket = server.accept();
            System.out.println("Nuovo client connesso: " + clientSocket.getInetAddress());

            // Un thread per ogni client
            ClientHandler handler = new ClientHandler(clientSocket);
            new Thread(handler).start();
        }
        
        
        //server.close();
    }
    
}
