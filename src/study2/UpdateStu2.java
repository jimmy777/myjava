package study2;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class UpdateStu2 {
    // 例子：14.6A
    public static void main(String[] args) {
        // 定义一个 HashMap 集合对象。
        HashMap<String, String> map = new HashMap<>();
        map.put("01","李同学");
        map.put("02","魏同学");
        map.put("03","赵同学");
        map.put("04","王同学");
        map.put("05", null);
        map.put("06", null);
        System.out.println(map);

        // 获取 HashMap 集合中所有的 key，结果放到一个 Set 集合中。
        Set<String> set = map.keySet();
        System.out.println(set);

        // 遍历 Set 集合。
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());

        // 获取 HashMap 集合中所有的 value，结果放到一个 Collection 集合中并且遍历显示。
        Collection<String> values = map.values();
        iterator = values.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());
    }
}
