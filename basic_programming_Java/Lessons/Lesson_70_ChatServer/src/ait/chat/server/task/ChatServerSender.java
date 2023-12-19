package ait.chat.server.task;

import ait.mediation.BlkQueue;

import java.io.*;
import java.net.Socket;
import java.util.List;
import java.util.stream.Collectors;

public class ChatServerSender implements Runnable {
    private BlkQueue<String> messageList;
    private Socket socket;
    private List<PrintWriter> clientList;

    public ChatServerSender(BlkQueue<String> messageList, Socket socket, List<PrintWriter> clientList) {
        this.messageList = messageList;
        this.socket = socket;
        this.clientList = clientList;
    }

    @Override
    public void run() {
        try (Socket socket = this.socket){
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter socketWriter = new PrintWriter(outputStream);
            String forwardedMessage = messageList.pop();

            clientList.stream()
                    .distinct()
                    .map(printWriter -> clientList.add(new PrintWriter(socketWriter)))
                    .collect(Collectors.toList());

            while (true){
                for (PrintWriter message: clientList) {
                    message.println(forwardedMessage);
                }
//                clientList.getLast().println(forwardedMessage);
//                clientList.removeFirst();
                socketWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
