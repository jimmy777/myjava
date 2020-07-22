package study1;

import java.util.Scanner;
import java.util.Stack;

public class Decode {
    // 例子：13.3.2A
    // Stack 栈操作例子
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Stack<Character> word = new Stack<>();

        String message;
        int index = 0;

        System.out.print("Enter the coded message: ");
        message = scan.nextLine();

        System.out.println("The decoded message is: ");
        while (index < message.length()) {
            // 遇到空格，即单词 word。
            while (index < message.length() && message.charAt(index) != ' ') {
                word.push(message.charAt(index));
                index++;
            }
            while (!word.empty())
                System.out.print(word.pop());
            System.out.print(" ");
            index++;
        }
        System.out.println();
    }
}
