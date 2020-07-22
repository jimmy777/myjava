package study2;

/*
    枚举类型
    values 返回数组
    valueOf 字符串转换为枚举型
    ordinal 返回索引值
 */

public class EnumDemo {
    enum Constants2 {
        Constants_A,
        Constants_B
    }

    public static void main(String[] args) {

        System.out.println(Constants2.valueOf("Constants_C"));
        for (int i=0;i<Constants2.values().length; i++) {
            System.out.println("枚举类型变量： " + Constants2.values()[i]);
        }
    }
}
