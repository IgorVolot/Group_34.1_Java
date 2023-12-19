package ait.chat.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.time.LocalDateTime;

public class ReceiverThread extends Thread {
    private BufferedReader reader;
    private Socket socket;
    private ChatClientAppl client;

    public ReceiverThread(Socket socket, ChatClientAppl client) {
        this.socket = socket;
        this.client = client;

        try {
            InputStream input = socket.getInputStream();
            reader = new BufferedReader(new InputStreamReader(input));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        while (true) {
            try {
                String response = reader.readLine();

                if (client.getUserName() != null) {
                    System.out.print("[" + client.getUserName() + "]: " + response + "\n");
                } else {
                    System.out.println(response + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
