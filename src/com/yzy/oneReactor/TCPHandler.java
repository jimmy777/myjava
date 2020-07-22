package com.yzy.oneReactor;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

public class TCPHandler implements Runnable {

    private final SelectionKey sk;
    private final SocketChannel sc;

    public TCPHandler(SelectionKey sk, SocketChannel sc) {

        this.sk = sk;
        this.sc = sc;
    }

    private void send(String str) throws IOException {
        String returnStr = "根据读取的数据返回响应" + sc.socket().getLocalSocketAddress().toString() + "\r\n";
        ByteBuffer buf = ByteBuffer.wrap(returnStr.getBytes());

        while (buf.hasRemaining()) {
            sc.write(buf);
        }
        sk.selector().wakeup();

    }

    @Override
    public void run() {
        byte[] arr = new byte[8];
        ByteBuffer buf = ByteBuffer.wrap(arr);

        int numBytes = 0; // 读取字符串

        try {
            numBytes = sc.read(buf);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (numBytes == -1) {
            System.out.println("[Warning!] A client has been closed.");
            closeChannel();
            return;
        }

        String str = new String(arr);
        if ((str != null) && !str.equals(" ")) {
            process(str); // 业务处理逻辑
            System.out.println(sc.socket().getRemoteSocketAddress().toString() + " > " + str);

            String returnStr = "服务端返回";
            ByteBuffer returnBuf = ByteBuffer.wrap(returnStr.getBytes());

            try {
                while (returnBuf.hasRemaining()) {
                    sc.write(returnBuf);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

//
//        try {
//            read(); // 读取数据
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    private synchronized void read() throws IOException {

        byte[] arr = new byte[8];
        ByteBuffer buf = ByteBuffer.wrap(arr);

        int numBytes = sc.read(buf); // 读取字符串
        if (numBytes == -1) {
            closeChannel();
            return;
        }

        String str = new String(arr); // 将读取到的 byte 内容转换为字符串
        if ((str != null) && !str.equals(" ")) {
            //str = process(str); // 处理业务逻辑
            process(str); // 处理业务逻辑
            System.out.println(sc.socket().getRemoteSocketAddress().toString() + " > " + str);
//            String returnStr = "服务端返回";
//            ByteBuffer returnBuf = ByteBuffer.wrap(returnStr.getBytes());
//            while (returnBuf.hasRemaining()) {
//                sc.write(returnBuf);
//            }
            send(str); // 根据读取的数据返回响应
            sk.selector().wakeup(); // 使一个阻塞住的 selector 操作立即返回
        }
    }

    private void process(String str) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void closeChannel() {
        sk.cancel();
        try {
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
