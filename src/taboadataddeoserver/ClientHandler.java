/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taboadataddeoserver;

import java.io.*;
import java.net.*;
import java.util.*;
/**
 *
 * @author tadde
 */
class ClientHandler implements Runnable {

    private final Socket clientSocket;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            DataInputStream dataInputStream = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
            Scanner scanner = new Scanner(System.in);

            // Primo messaggio
            dataOutputStream.writeUTF("Ciao sono il server di Taddeo!");

            String clientMessage;
            String message;

            do {
                clientMessage = dataInputStream.readUTF();
                System.out.println("[" + clientSocket.getInetAddress() + "] Ricevuto: " + clientMessage);

                if (clientMessage.equals("Arrivederci")) {
                    dataOutputStream.writeUTF("Arrivederci");
                    break;
                }

                System.out.println("Scrivi il tuo messaggio:");
                message = scanner.nextLine();
                dataOutputStream.writeUTF(message);

            } while (!clientMessage.equals("Arrivederci"));

        } catch (IOException e) {
            System.out.println("Connessione con il client interrotta: " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
                System.out.println("Client disconnesso.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
