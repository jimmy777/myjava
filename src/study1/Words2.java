package study1;

import libs.Dictionary2;

public class Words2 {
    // 例子：9.1.2A Words2
    // 功能：优化了之前 Word 的代码，子类利用 super 调用父类的构造函数。
    public static void main(String[] args) {
        // 创建子类对象，且初始化了父类的变量。
        Dictionary2 webster = new Dictionary2(1500, 52500);

        System.out.println("Number of pages: " + webster.getPages());

        System.out.println("Number of definitions: " + webster.getDefinitions());

        System.out.println("Definitions per page: " + webster.computeRatio());

    }
}