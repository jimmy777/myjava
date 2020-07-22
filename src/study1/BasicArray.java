package study1;

public class BasicArray {
    // 例子：8.2A BasicArray
    // 功能：数组的例子。
    public static void main(String[] args) {

        final int LIMIT = 15, MULIPLE = 10;

        int[] list = new int[LIMIT];

        for (int index = 0; index < LIMIT; index++)
            list[index] = index * MULIPLE;

        list[5] = 999;

        // for 循环的迭代器遍历数组
        for (int value : list)
            System.out.print(value + "\t");
    }
}
