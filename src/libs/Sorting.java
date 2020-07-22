package libs;

public class Sorting<T> {

    // 1. 选择排序算法 selectionSort；
    // 取得第一个最小值，扫描之后所有值与其比较，小的值进行互换排前面，否则不动位置。
    // 比较直到最后一个值，即完成从小到大值得排序。
    // 重写 Comparable 接口的比较方法。
    public void selectionSort(Comparable<T>[] list) {
        int min;
        Comparable<T> temp;

        for (int index = 0; index < list.length - 1; index++) {
            min = index;
            for (int scan = index + 1; scan < list.length; scan++) {
                if (list[scan].compareTo((T) list[min]) < 0)
                    min = scan;
            }

            temp = list[min];
            list[min] = list[index];
            list[index] = temp;
        }
    }

    // 2. 插入排序算法
    // 插入算法，也用二重循环对数组排序，但外循环控制的是下一下要插入的值在数组中的位置索引，内循环将外循环所控制的值与数列中待比较的值逐一比较。
    // 两种算法都执行大约n2次比较操作，其中n是数列中值得个数。
    // 我们称选择法排序和插入法排序都是n2阶算法。
    public void insertionSort(Comparable<T>[] list) {
        for (int index = 1; index < list.length; index++) {
            Comparable<T> key = list[index];
            int postion = index;

            while (postion > 0 && key.compareTo((T) list[postion - 1]) < 0) {
                list[postion] = list[postion - 1];
                postion--;
            }

            list[postion] = key;
        }
    }
}
