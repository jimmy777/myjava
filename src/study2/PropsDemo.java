package study2;

import java.io.IOException;
import java.util.Properties;

public class PropsDemo {
    public static void main(String[] args) throws IOException {
        // 自定义文件，包括键值。
        // 类似 HashMap
        Properties props = new Properties();

        props.put("Adobe", "Mountain View, CA");
        props.put("IBM", "White Plains, NY");
        props.put("Learning Tree", "Los Angeles, CA");

        // props.load(System.in);

        props.list(System.out);


    }
}
