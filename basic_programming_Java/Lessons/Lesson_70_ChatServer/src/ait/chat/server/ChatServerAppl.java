package ait.chat.server;

import ait.chat.server.task.ChatServerReceiver;
import ait.chat.server.task.ChatServerSender;
import ait.mediation.BlkQueue;
import ait.mediation.BlkQueueImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ChatServerAppl {
    private static BlkQueueImpl<String> blkQueue;
    private static BlkQueue<String> messageList;
    private static List<PrintWriter> clientList;
    public static void main(String[] args) {
        int port = 9000;
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            try {
                while (true) {
                    ChatServerReceiver serverReceiver = new ChatServerReceiver(blkQueue, serverSocket.accept());
                    ChatServerSender serverSender = new ChatServerSender(messageList, serverSocket.accept(), clientList);
                    executorService.execute(serverReceiver);
                    executorService.execute(serverSender);
                    Thread receiver =new Thread(new ChatServerReceiver(blkQueue,serverSocket.accept()));
                    Thread sender = new Thread(new ChatServerSender(messageList, serverSocket.accept(), clientList));
                    receiver.setDaemon(true);
                    receiver.start();
                    sender.start();
                }
            } finally {
                executorService.shutdown();
                executorService.awaitTermination(1, TimeUnit.MINUTES);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }

}
