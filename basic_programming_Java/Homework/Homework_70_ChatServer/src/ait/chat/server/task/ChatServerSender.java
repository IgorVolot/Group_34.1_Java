package ait.chat.server.task;

import ait.mediation.BlkQueue;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class ChatServerSender implements Runnable {
    private BlkQueue<String> messageList;
    private Socket socket;
    private Set<PrintWriter> userList;

    public ChatServerSender(BlkQueue<String> messageList, Socket socket) {
        this.messageList = messageList;
        this.socket = socket;
        this.userList = new HashSet<>();
    }

    @Override
    public void run() {
        try (Socket socket = this.socket) {
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter socketWriter = new PrintWriter(outputStream);
            if (socketWriter.equals(null)) {
                removeUser(socketWriter);
            } else {
                addUser(socketWriter);
            }

            while (true) {
                String forwardedMessage = messageList.pop();
                userList.forEach(message -> message.println(forwardedMessage));
                socketWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean addUser(PrintWriter user) {
        if (user.equals(null)) {
            throw new RuntimeException("User cannot be null");
        }
        return userList.add(user);
    }

    private void removeUser(PrintWriter user) {
        PrintWriter victim = userList.stream()
                .filter(u -> u.equals(user))
                .findFirst().get();
        userList.remove(victim);
    }
}
