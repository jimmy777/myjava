package study2;

import libs.StructureDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ArrayListDemo {
    public static void main(String[] args) {

        ArrayList<Object> al = new ArrayList<>();

        // 创建一个对象。
        StructureDemo source = new StructureDemo(1, "2012-01-01");

        al.add(source.getsDate());
        al.add(source.getsDate());
        al.add(source.getsDate());

        for (int i=0;i<al.size();i++)
            System.out.println("Element: " + i + "\t" + al.get(i));

        // 从数组转换成列表
        List<String> firstNames = Arrays.asList("Robin", "Jaime", "Joey");
        System.out.println(firstNames);

        Object[] array = firstNames.toArray();
        for (Object o : array) {
            System.out.println(o);
        }



    }
}
