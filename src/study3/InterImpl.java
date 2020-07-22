package study3;

/*
    接口的实现类。
    1、明确实现接口的泛型的类型，如String；
    2、运行的时候或调用的时候再指定类型，使用泛型。（常用）
        实现的类要声明成泛型定义在类上。
 */
//public class InterImpl implements Inter<String> {
//    @Override
//    public void show(String s) {
//        System.out.println(s);
//    }
//}

public class InterImpl<T> implements Inter<T>{

    @Override
    public void show(T t) {
        System.out.println(t);
    }
}