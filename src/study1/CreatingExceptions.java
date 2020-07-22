package study1;

import libs.OutOfRangeException;

import java.util.Scanner;

public class CreatingExceptions {
    // 例子：11.5A
    // 自定义异常类
    // main 方法没有捕获异常，所以如出现异常，则程序直接退出了。
    public static void main(String[] args) throws OutOfRangeException {
        final int MIN = 25, MAX = 40;
        Scanner scan = new Scanner(System.in);

        // 定义异常对象
        OutOfRangeException problem = new OutOfRangeException("Input value is out of range.");

        System.out.print("Enter an  integer value between " + MIN + " and " + MAX + ", inclusive: ");
        int value = scan.nextInt();

        // 抛出异常对象
        if (value < MIN || value > MAX)
            throw problem;

        System.out.println("End of main method.");
    }
}
