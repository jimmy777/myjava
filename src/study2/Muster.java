package study2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Muster {
    // 例子：book2-14.1A
    public static void main(String[] args) {
        // 定义一个 ArrayList 对象集合。
        Collection<String> list = new ArrayList<>();

        // 调用了对象集合的方法。
        list.add("a");
        list.add("b");
        list.add("c");

        // 定义一个迭代器。
        Iterator<String> it = list.iterator();

        while (it.hasNext()){
            String str = (String)it.next(); // 获取集合中的元素 Object 对象，然后进行了强转换。
            System.out.println(str);
        }
    }
}
