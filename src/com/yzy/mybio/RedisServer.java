package com.yzy.mybio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class RedisServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9090);
        while (true){
            Socket socket = serverSocket.accept(); // 阻塞1
            System.out.println("xxxx 来连接了。");

            // 一般下面会开 Thread 线程去处理 read（）方法，这样才能并发处理。


            byte[] bytes = new byte[1024];
            socket.getInputStream().read(bytes); // 阻塞2
            System.out.println("收到客户端的消息：" + new String(bytes));
        }
    }
}
