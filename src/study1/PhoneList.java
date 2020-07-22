package study1;

import libs.Contact;
import libs.Searching;
import libs.Sorting;

public class PhoneList {
    public static void main(String[] args) {

        // 例子：10.4A PhoneList
        // 定义一些要排序的值，Contact 对象数组。
        Contact[] friends = new Contact[8];

        friends[0] = new Contact("John", "Smith", "610-555-7384");
        friends[1] = new Contact("Sarah","Barnes","215-555-3827");
        friends[2] = new Contact("Mark","Riley","733-555-2069");
        friends[3] = new Contact("Laura","Getz","663-555-3984");
        friends[4] = new Contact("Larry","Smith","464-555-3489");
        friends[5] = new Contact("Frank","Phelps","322-555-2284");
        friends[6] = new Contact("Mario","Guzman", "804-555-9066");
        friends[7] = new Contact("Marsha","Grant","243-555-2837");

        // 自定义的 Sorting 类
        Sorting<Contact> sorts = new Sorting<>();
        // 调用选择排序算法 selectionSort
        System.out.println("选择排序结果：");
        sorts.selectionSort(friends);
        System.out.println("=====================");

        for (Contact friend: friends)
            System.out.println(friend);

        // 调用插入排序算法 insertionSort
        System.out.println("插入排序结果：");
        sorts.insertionSort(friends);
        System.out.println("=====================");

        for (Contact friend: friends)
            System.out.println(friend);

        // 例子：搜索算法 1
        Searching<Contact> searchs = new Searching<Contact>();

        Contact test, found;

        test = new Contact("Frank","Phelps","");
        System.out.println("线性搜索算法：");
        found = searchs.linearSearch(friends, test);
        if (found!=null)
            System.out.println("Found: " + found);
        else
            System.out.println("The Contact was not found.");

        System.out.println("=====================");

        // 例子：搜索算法 2
        // 先调用一下排序算法
        Sorting<Contact> sorts2 = new Sorting<Contact>();
        sorts2.selectionSort(friends);

        test = new Contact("Mario", "Guzman","");
        found = (Contact)searchs.binarySearch(friends, test);
        if (found != null)
            System.out.println("Fount: ");
        else
            System.out.println("The Contact was not found.");

    }
}
