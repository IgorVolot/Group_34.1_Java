package ait.chat.client;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.time.LocalDateTime;

    /*
    Надо написать консольный чат клиент. В отличии от клиента, который сделали в классе, чат клиент должен
    отправлять сообщения на сервер не дожидаясь получения ответа от сервера. И печатать сообщения полученные
    от сервера, не зависимо от того пишет что-то пользователь, или нет. Т. е. отправитель и получатель,
    это две независимые задачи внутри клиентской аппликации.
     */

public class ChatClientAppl {
    private String serverHost;
    private int port;
    private String userName;
    public static void main(String[] args) {
        String serverHost = "127.0.0.1"; // localhost
        int port = 9000;

        ChatClientAppl client = new ChatClientAppl(serverHost, port);
        try {
            Socket socket = new Socket(serverHost, port);

            System.out.println("Connected to the chat server");

            new ReceiverThread(socket, client).start();
            new SenderThread(socket, client).start();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public ChatClientAppl(String serverHost, int port) {
        this.serverHost = serverHost;
        this.port = port;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
