package study3;

/*
    接口测试类。

 */
public class InterDemo {
    public static void main(String[] args) {
        // 声明一个接口变量，指向实际的接口实现类，即接口的多态实现。
        // 接口变量需要指定泛型的类型。
        Inter<String> i = new InterImpl<String>();
        i.show("hello");

    }
}
