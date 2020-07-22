package study2;

import libs.Emp;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class MapTest {
    public static void main(String[] args) {
        // 定义一个 HashMap 集合。
        HashMap<Object, Object> map = new HashMap<>();
        System.out.println(map);

        Emp emp1 = new Emp("001", "张三");
        Emp emp2 = new Emp("005", "李四");
        Emp emp3 = new Emp("004", "王一");

        map.put(emp1.getId(), emp1.getName());
        map.put(emp2.getId(), emp2.getName());
        map.put(emp3.getId(), emp3.getName());

        System.out.println(map);

        Set<Object> set = map.keySet();
        System.out.println(set);

        Iterator<Object> iterator = set.iterator();
        while (iterator.hasNext()) {
            String sId = (String)iterator.next();
            String sName = (String)map.get(sId);
            System.out.println("工号：" + sId + " \t" + "姓名：" + sName);
        }

        // 定义一个 TreeMap 集合。
        TreeMap<Object, Object> tree = new TreeMap<>();
        tree.putAll(map); // 将 HashMap 集合的元素都放入 TreeMap 集合对象中保存。
        System.out.println(tree);

        iterator = tree.keySet().iterator();
        while (iterator.hasNext()) {
            String sId = (String)iterator.next();
            String sName = (String)map.get(sId);
            System.out.println("工号：" + sId + " \t" + "姓名：" + sName);
        }


    }
}
