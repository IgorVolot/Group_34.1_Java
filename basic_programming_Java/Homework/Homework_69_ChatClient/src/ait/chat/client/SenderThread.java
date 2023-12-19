package ait.chat.client;

import java.io.*;
import java.net.Socket;

public class SenderThread extends Thread{
    private PrintWriter writer;
    private BufferedReader br;
    private Socket socket;
    private ChatClientAppl client;

    public SenderThread(Socket socket, ChatClientAppl client) {
        this.socket = socket;
        this.client = client;

        try {
            OutputStream output = socket.getOutputStream();
            writer = new PrintWriter(output, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("\nEnter your name: ");
            String userName = br.readLine();
            client.setUserName(userName);
            writer.println(userName);
            String message = br.readLine();

            while (!message.equalsIgnoreCase("exit")){
                message = br.readLine();
                writer.println(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
