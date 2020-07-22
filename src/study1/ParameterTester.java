package study1;

import libs.Num;
import libs.ParameterModifier;

public class ParameterTester {

    // 例子：7.7.2A ParameterTester
    // 功能：形参为基本数据类型、对象。
    public static void main(String[] args) {
        ParameterModifier modifier = new ParameterModifier();

        int a1 = 111;
        Num a2 = new Num(222);
        Num a3 = new Num(333);

        System.out.println("Before calling changeValues:");
        System.out.println("a1\ta2\ta3");
        System.out.println(a1 + "\t" + a2 + "\t" + a3 + "\n");

        // 传入参数。
        modifier.changeValues(a1, a2, a3);

        System.out.println("After calling changeValues");
        System.out.println("a1\ta2\ta3");
        System.out.println(a1 + "\t" + a2 + "\t" + a3 + "\n");
    }
}
