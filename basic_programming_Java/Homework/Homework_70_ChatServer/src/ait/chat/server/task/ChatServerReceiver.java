package ait.chat.server.task;

import ait.mediation.BlkQueue;
import ait.mediation.BlkQueueImpl;

import java.io.*;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class ChatServerReceiver implements Runnable {
    private BlkQueue<String> messageBox;
    private Socket socket;

    public ChatServerReceiver(BlkQueue<String> messageBox, Socket socket) {
        this.messageBox = messageBox;
        this.socket = socket;
    }

    @Override
    public void run() {
        try (Socket socket = this.socket) {
            BufferedReader socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true) {
                String receivedMessage = socketReader.readLine();
                if (receivedMessage == null){
                    break;
                }
                messageBox.push(receivedMessage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
