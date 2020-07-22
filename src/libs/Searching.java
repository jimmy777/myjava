package libs;

public class Searching<T> {
    // 例子：10.5.1A
    // 1. 线性搜索算法
    // 参数列表和要搜索的目标，两者要同类型。
    public T linearSearch(T[] list, T target) {
        int index = 0;
        boolean found = false;

        while (!found && index<list.length){
            if (list[index].equals(target))
                found = true;
            else
                index++;
        }

        if (found)
            return list[index];
        else
            return null;
    }

    // 例子：10.5.2A
    // 2. 二分法搜索
    public Comparable<T> binarySearch(Comparable<T>[] list, Comparable<T> target){
        int min=0, max=list.length-1, mid = 0;
        boolean found=false;

        while (!found && min<=max){
            mid = (min + max)/2;
            if (list[mid].equals(target))
                found = true;
            else
                if (target.compareTo((T)list[mid])<0)
                    max = mid -1;
                else
                    min = mid + 1;
        }

        if (found)
            return list[mid];
        else
            return null;
    }

}
