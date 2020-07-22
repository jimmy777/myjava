package com.yzy.oneReactor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

public class TCPReactor implements Runnable {

    private final ServerSocketChannel ssc;
    private final Selector selector;

    public TCPReactor(int port) throws IOException {
        selector = Selector.open(); // 创建一个选择器对象
        ssc = ServerSocketChannel.open(); // 打开服务端 socket
        InetSocketAddress addr = new InetSocketAddress(port);
        ssc.socket().bind(addr); // 给 ServerSocketChannel 绑定端口
        ssc.configureBlocking(false); // 设置 ServerSocketChannel 为非阻塞
        /**
         * 上面的代码和 BIO 差不多。
         * selector 对象可以理解为一个集合，专门用来存放事件的。然后再轮询这些事件。
         * selector 很重要，serverSocker 对象的 ACCEPT 事件，即连接事件。
         * 下面的两行代码 NIO 很关键。
         */

        SelectionKey sk = ssc.register(selector, SelectionKey.OP_ACCEPT); // 注册一个 Server 端的 socket 对象
        sk.attach(new Acceptor(selector, ssc)); // 给 Server socket 对象，附加一个 Acceptor 对象

    }

    @Override
    public void run() {
        while (!Thread.interrupted()){
            System.out.println("waiting for new event on port: " + ssc.socket().getLocalPort() + " ...");
            try {
                if (selector.select() == 0){
                    continue;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("第一次有客户端连接。");

            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> it = selectionKeys.iterator();

            while (it.hasNext()) {
                SelectionKey selectionKey = it.next();
                dispatch(selectionKey);
                it.remove();
            }
        }
    }

    private void dispatch(SelectionKey selectionKey) {
        /**
         * 取出附加对象，根据附加对象判断是什么事件，调用不同的附加对象的run方法，
         * 如果是接受客户端连接的时间的话，这里取出的附加对象就是 Acceptor，调用其 run 方法
         * 如果是已经连接上来的客户端发来的数据，则是读事件，取出的附件对象就是 TCPHandler
         * new Acceptor(selector,ssc).run()
         */
        Runnable r = (Runnable) (selectionKey.attachment()); // 取出附加对象
        if (null != r){
            r.run();
        }
    }
}
