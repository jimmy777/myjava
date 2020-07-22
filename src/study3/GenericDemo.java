package study3;

import com.sun.javafx.scene.control.skin.VirtualFlow;

import java.util.ArrayList;
import java.util.Collection;

/*
    泛型明确写的时候，左右必须类型保持一致。

    泛型高级应用：
    ? 表示任意类型
    ? extends E 向下限定，其子类
    ? super E 向上限定，其父类

 */
public class GenericDemo {
    public static void main(String[] args) {
        Collection<Object> objects = new ArrayList<Object>();

        // 可以是任意类型。
        Collection<?> c1 = new ArrayList<Object>();
        Collection<?> c2 = new ArrayList<Animal>();
        Collection<?> c3 = new ArrayList<Dog>();
        Collection<?> c4 = new ArrayList<Cat>();

        // 向下兼容，Animal自己和子类。
//        Collection<? extends Animal> c11 = new ArrayList<Object>();
        Collection<? extends Animal> c22 = new ArrayList<Animal>();
        Collection<? extends Animal> c33 = new ArrayList<Dog>();
        Collection<? extends Animal> c44 = new ArrayList<Cat>();

        // 向上兼容，Animal自己和父类。
        Collection<? super Animal> c111 = new ArrayList<Object>();
        Collection<? super Animal> c222 = new ArrayList<Animal>();
//        Collection<? super Animal> c333 = new ArrayList<Dog>();
//        Collection<? super Animal> c444 = new ArrayList<Cat>();


    }
}

class Animal {
}

class Dog extends Animal {
}

class Cat extends Animal {
}
