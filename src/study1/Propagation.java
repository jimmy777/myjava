package study1;

import libs.ExceptionScope;

public class Propagation {
    // 例子：11.4A
    public static void main(String[] args) {
        ExceptionScope demo = new ExceptionScope();

        System.out.println("Program beginning.");
        demo.level1();
        System.out.println("Program ending.");
    }
}
