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
        /*
        int port = 12345;
        ServerSocket server;
        server = new ServerSocket(port);
        
        Socket client = server.accept();
        
        InputStream inputStream = client.getInputStream();
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        String clientMessage = dataInputStream.readUTF(); // Su clientMessage ho i dati del Client
        System.out.println(clientMessage);
        
        OutputStream outputStream = client.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        String response = "Ciao, client!"; dataOutputStream.writeUTF(response);
        
        client.close();
        server.close();
        */
        
        int porta=12345;
        ServerSocket server=new ServerSocket(porta);
        Socket clientSocket = server.accept();
        String response;
        Scanner scanner=new Scanner(System.in);
       
        InputStream inputStream = clientSocket.getInputStream();
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        OutputStream outputStream = clientSocket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
       
        do{
        String clientMessage = dataInputStream.readUTF(); // Su clientMessage ho i dati del Client
        System.out.println("messaggia:");
        response = scanner.next();
        dataOutputStream.writeUTF(response);
       
        System.out.println(response);
        System.out.println(clientMessage);
        }while(!response.equals("Arrivederci"));
        clientSocket.close();
        server.close();
    }
    
}
