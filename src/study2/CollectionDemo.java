package study2;

import java.util.*;

public class CollectionDemo {

    public static void main(String[] args) {
        // 例子：book3-7.10A
        // 定义一个链表集合对象（String 类型）。
        LinkedList<String> lst = new LinkedList<>();

        lst.add(new Object().toString());
        lst.add("Hello");
        lst.add("end of the list.");

        System.out.println(lst);

        // ListIterator 是 Iterator 的子接口。
        ListIterator<String> li = lst.listIterator(0);
        while (li.hasNext())
            System.out.println("Next to: " + li.next());

        System.out.println("----------------------------");

        // 例子：book3-7.11A
        // 定义一个 HashMap 对象。
        HashMap<String, String> map = new HashMap<>();
        map.put("Adobe", "Mountain View, CA");
        map.put("IBM", "White Plains, NY");
        map.put("Learning Tree", "Los Angeles, CA");
        System.out.println(map);

        // 按关键字搜索方法。
        String result = map.get("IBM");
        System.out.println(result);

        // 获取所有的键值，并遍历。
        for (String key: map.keySet())
            System.out.println("Key: "+key+ "\t"+"Value: " + map.get(key));

        System.out.println("----------------------------");


        // forEach 使用了 lambda 表达式。
        // map.entrySet 每一个元素是一个键值对。
        Set<Map.Entry<String, String>> entries = map.entrySet();
        System.out.println(entries);
        map.entrySet().forEach(mE -> System.out.println("Key: "+mE.getKey()+"\t"+"Value: "+mE.getValue()));

        System.out.println("----------------------------");


        //
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next();
            if (key.equals("IBM")) {
                it.remove();
                continue;
            }
            System.out.println("Company: " + key + "\t" + "Address: " + map.get(key));
        }

        System.out.println("----------------------------");

        TreeSet<String> theSet = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        theSet.add("Gosling");
        theSet.add("da Vinci");
        theSet.add("van Gogh");
        theSet.add("Java To Go");
        theSet.add("Vanguard");
        theSet.add("Darwin");
        theSet.add("Darwin");

        System.out.println(theSet);
        System.out.printf("Our set contains %d elements.", theSet.size());
        System.out.println("Lowest (alphabetically) is " + theSet.first());
        System.out.println(theSet.tailSet("k").toArray().length + " elements higher than \"k\"");
        System.out.println("Sorted list: ");
        theSet.forEach(name -> System.out.println(name));

        System.out.println("----------------------------");

        /*
        搜索
         */
        Random random = new Random();
        int[] ints = new int[10];
        for (int i=0;i<10;i++)
            ints[i] = random.nextInt(10);

        Arrays.sort(ints);

        int i = Arrays.binarySearch(ints, 6);
        if (i>=0) {
            System.out.println("Value 6 occurs at haystack[" + i + "]");
        }
        else {
            System.out.println("Value 6 does not occurs in haystack.");
        }

        System.out.println("----------------------------");

        /*
        队列转成数组 toArray()
         */

        Object[] objects = lst.toArray();
        System.out.println(objects.length);

        String[] strings = lst.toArray(new String[0]);
        System.out.println(strings.length);

        System.out.println("----------------------------");
        /*
        ArrayList 使用迭代器 Iterator()，两种方法调用。
         */

        ArrayList<String> al = new ArrayList<>();
        al.add("fisrt");
        al.add("second");
        al.add("third");

        // Java 5/6 方式
        for (String s: al)
            System.out.println(s);

        System.out.println();

        // Java 8 方式，使用 lambda 表达式。
        al.forEach(s -> System.out.println(s));






    }
}
