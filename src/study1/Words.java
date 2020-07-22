package study1;

import libs.Dictionary;

public class Words {
    public static void main(String[] args) {
        // 实例化子类 Dictionary，但不用实例化父类 Book。
        Dictionary webster = new Dictionary();
        System.out.println("Number of pages: " + webster.getPages());

        System.out.println("Number of definitions: " + webster.getDefinitions());

        System.out.println("Definitions per page: " + webster.computeRatio());
    }
}
