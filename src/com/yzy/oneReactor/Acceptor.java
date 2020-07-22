package com.yzy.oneReactor;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class Acceptor implements Runnable {

    private final ServerSocketChannel ssc;
    private final Selector selector;

    public Acceptor(Selector selector, ServerSocketChannel ssc) {
        this.ssc = ssc;
        this.selector = selector;
    }

    @Override
    public void run() {
        try {
            SocketChannel sc = ssc.accept(); // 接受 client 连接请求
            System.out.println(sc.socket().getRemoteSocketAddress().toString() + " is connecting.");
            if (sc!=null){
                sc.configureBlocking(false); // 设置非阻塞
                SelectionKey sk = sc.register(selector, SelectionKey.OP_READ); // 注册为读事件，上面又加入了一个 socket。
                selector.wakeup(); // 使一个阻塞住的 selector 操作立即返回
                sk.attach(new TCPHandler(sk, sc)); // 给定 key 一个附加的 TCPHandler 对象
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
