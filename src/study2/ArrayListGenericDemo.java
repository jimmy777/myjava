package study2;

import java.util.*;

public class ArrayListGenericDemo {
    public static void main(String[] args) {
        ArrayList<String> data = new ArrayList<>();

        data.add("hello");
        data.add("goodbye");
        // 类型检查不是 String，所以报错。
        // data.add(123);
        // data.add(new Date());

        data.forEach(s -> System.out.println(s));

        // Person 作为关键字，Address 作为值。
        // HashMap<Object, Object> addressMap = new HashMap<>();


        // 1.声明一个集合；
        // 2.使用 Arrays.asList 来填充；
        // 3.调用集合的 forEach 方法，参数为一个 Lambda 表达式。
        Collection<String> c = Arrays.asList("One", "Two", "Three");
        c.forEach(s -> System.out.println(s));
        System.out.println("-------------------- end");

        // Iterable 比较常见。
        for (String s: c) {
            System.out.println(s);
        }
        System.out.println("-------------------- end");

        // Iterator 迭代器
        Iterator<String> iterator = c.iterator();
        while(iterator.hasNext())
            System.out.println(iterator.next());
        System.out.println("-------------------- end");

    }
}
