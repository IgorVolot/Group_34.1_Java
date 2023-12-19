package ait.chat.server.task;

import ait.mediation.BlkQueueImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
public class ChatServerReceiver implements Runnable {
    private BlkQueueImpl<String> blkQueue;
    private Socket socket;

    public ChatServerReceiver(BlkQueueImpl<String> blkQueue, Socket socket) {
        this.blkQueue = blkQueue;
        this.socket = socket;
    }

    @Override
    public void run() {
        try(Socket socket = this.socket) {
            InputStream inputStream = socket.getInputStream();
            BufferedReader socketReader = new BufferedReader(new InputStreamReader(inputStream));
            String receivedMessage = socketReader.readLine();
            while (true) {
                if (receivedMessage == null) {
                    break;
                }
                blkQueue.push(receivedMessage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
