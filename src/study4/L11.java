package study4;

import java.util.Random;

public class L11 {
    static Random random = new Random();

    private final int VALUE_1 = 9;

    private static final int VALUE_2 = 10;

    private final Test test = new Test();

    private Test test2 = new Test();

    private final int[] a = {1, 2, 3, 4, 5, 6};

    private final int i4 = random.nextInt(20);
    private static final int i5 = random.nextInt(20);

//    public L11(Test test2) {
//        this.test2 = test2;
//    }

    @Override
    public String toString() {
        return i4 + " " + i5 + " ";
    }

    public static void main(String[] args) {
        /*
            1. final 变量
         */
//        L11 data = new L11();
//        data.test = new Test(); // 这句错误，final 不能再改变引用了。
//        data.VALUE_1++; // 这句错误，final 变量不能再改变其值了。
//        data.test2 = new Test(); // 这句正确，没有 final 修饰符可以改变其引用对象。
//        for (int i=0;i<data.a.length;i++)
//            data.a[i] = 9;

        /*
            2. final 方法
         */

        /*
            3. final 类
         */
        FinalClass fc = new FinalClass();
        fc.a++; // 可以修改
        System.out.println(fc.a);
    }
}
