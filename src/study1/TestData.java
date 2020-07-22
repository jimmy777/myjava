package study1;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class TestData {
    // 例子：11.6A
    public static void main(String[] args) throws FileNotFoundException {
        final int MAX = 10;

        int value;
        String fileName = "test.txt";
        // PrintWriter 对象也有类似 Print 方法用来写文件。
        // 会抛出检查型异常，但其没有处理，必须在方法声明头中写 throws子句。
        PrintWriter outFile = new PrintWriter(fileName);
        // 随机数
        Random rand = new Random();
        for (int line = 1; line < MAX; line++) {
            for (int num = 1; num <= MAX; num++) {
                value = rand.nextInt(90) + 10;
                outFile.print(value + "\t");
            }
            outFile.println();
        }
        // 必须明确地关闭输出文件流。
        outFile.close();
        System.out.println("Output file has been created: " + fileName);
    }
}
