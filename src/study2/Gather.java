package study2;

import java.util.ArrayList;

public class Gather {
    // 例子：book2-14.4A
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        list.add("a");
        list.add("b");
        list.add("c");

        // random 方法获得 0.0 ~ 1.0 之间的随机数。
        int i = (int) (Math.random() * (list.size() - 1));
        System.out.println("随机获取数组中的元素： " + list.get(i));
        // 集合的索引从 0 开始的。
        list.remove(2);
        System.out.println("将索引是2的元素移除后，数组中的元素是：");
        for (int j = 0; j < list.size(); j++)
            System.out.println(list.get(j));
    }
}
