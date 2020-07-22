package com.yzy.oneReactor;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 1333);
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        socket.getOutputStream().write((s.getBytes()));
        socket.close();
    }
}
