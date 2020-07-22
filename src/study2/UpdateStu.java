package study2;

import java.util.Iterator;
import java.util.TreeSet;

public class UpdateStu implements Comparable<Object> {
    String name;
    long id;

    public UpdateStu(String name, long id) {
        this.name = name;
        this.id = id;
    }

    public static void main(String[] args) {
        UpdateStu stu1 = new UpdateStu("李同学", 01011);
        UpdateStu stu2 = new UpdateStu("陈同学", 01021);
        UpdateStu stu3 = new UpdateStu("王同学", 01051);
        UpdateStu stu4 = new UpdateStu("马同学", 01012);

        // 定义一个 TreeSet 集合，元素为 UpdateStu。
        // TreeSet 集合内的元素必须实现 Comparable 接口，防止集合中有相同的元素。
        TreeSet<UpdateStu> tree = new TreeSet<>();
        tree.add(stu1);
        tree.add(stu2);
        tree.add(stu3);
        tree.add(stu4);

        // 遍历集合
        Iterator<UpdateStu> iterator = tree.iterator();
        while (iterator.hasNext()) {
            UpdateStu stu = (UpdateStu) iterator.next();
            System.out.println(stu.getId() + "\t" + stu.getName());
        }
        System.out.println("------------------------------");

        // 截取 stu2 之前的对象
        iterator = tree.headSet(stu2).iterator();
        while (iterator.hasNext()) {
            UpdateStu stu = (UpdateStu) iterator.next();
            System.out.println(stu.getId() + "\t" + stu.getName());
        }
        System.out.println("------------------------------");

        // 获取 stu2 和 stu3 之间的对象
        iterator = tree.subSet(stu2, stu3).iterator();
        while (iterator.hasNext()) {
            UpdateStu stu = (UpdateStu) iterator.next();
            System.out.println(stu.getId() + "\t" + stu.getName());
        }
        System.out.println("------------------------------");
    }

    @Override
    public int compareTo(Object o) {
        UpdateStu upstu = (UpdateStu) o;
        int result = id > upstu.id ? 1 : (id == upstu.id ? 0 : -1); // 这句挺难。
        return result;
    }


    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }
}
