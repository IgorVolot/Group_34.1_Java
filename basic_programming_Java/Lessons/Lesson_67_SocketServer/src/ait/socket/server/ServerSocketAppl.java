package ait.socket.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalTime;

public class ServerSocketAppl {
    public static void main(String[] args) {
        int port = 9000;
        try (ServerSocket serverSocket = new ServerSocket(port)){
            while (true){
                System.out.println("server wait...");
                Socket socket = serverSocket.accept();  // double handshake
                System.out.println("Connection established");
                System.out.println("Client host: " + socket.getInetAddress() + ":" + socket.getPort());

                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();

                PrintWriter socketWriter = new PrintWriter(outputStream);
                BufferedReader socketReader = new BufferedReader(new InputStreamReader(inputStream));

                while (true){
                    String message = socketReader.readLine();
                    if (message == null){
                        break;
                    }
                    System.out.println("Server received: " + message);
                    socketWriter.println(message + " " + LocalTime.now());
                    socketWriter.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
