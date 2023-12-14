package ait.socket.client;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientSocketAppl {
    public static void main(String[] args) {
        String serverHost = "127.0.0.1"; // localhost
        int port = 9000;

        try (Socket socket = new Socket(serverHost, port)) {
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter socketWriter = new PrintWriter(outputStream);
            BufferedReader socketReader = new BufferedReader(new InputStreamReader(inputStream));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter your message or type exit to quit");
            String message = br.readLine();
            while (!"exit".equalsIgnoreCase(message)) {
                socketWriter.println(message);
                socketWriter.flush();
                String response = socketReader.readLine();
                System.out.println(response);
                System.out.println("Enter your message or type exit to quit");
                message = br.readLine();
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
