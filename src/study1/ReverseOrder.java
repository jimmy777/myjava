package study1;

import java.util.Scanner;

public class ReverseOrder {

    // 例子：8.2A 数组倒序
    // 功能：控制 index 索引的开始和结束值。
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        double[] numbers = new double[10];

        System.out.println("The size of the array: " + numbers.length);

        for (int index = 0; index < numbers.length; index++) {
            System.out.println("Enter number " + (index + 1) + ": ");
            numbers[index] = scan.nextDouble();
        }

        System.out.println("The numbers in reverse order:");

        for (int index = numbers.length - 1; index >= 0; index--)
            System.out.print(numbers[index] + "\t");
    }
}
