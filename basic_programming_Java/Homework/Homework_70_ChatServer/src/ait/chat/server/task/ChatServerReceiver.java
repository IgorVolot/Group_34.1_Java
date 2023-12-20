package ait.chat.server.task;

import ait.mediation.BlkQueueImpl;

import java.io.*;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class ChatServerReceiver implements Runnable {
    private BlkQueueImpl<String> messageList;
    private Socket socket;
    private Set<PrintWriter> userList;

    public ChatServerReceiver(BlkQueueImpl<String> messageList, Socket socket) {
        this.messageList = messageList;
        this.socket = socket;
        this.userList = new HashSet<>();
    }

    @Override
    public void run() {
        try (Socket socket = this.socket) {
            InputStream inputStream = socket.getInputStream();
            BufferedReader socketReader = new BufferedReader(new InputStreamReader(inputStream));
            String receivedMessage = socketReader.readLine();
            while (true) {
                if (receivedMessage == null) {
                    break;
                }
                messageList.push(receivedMessage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
