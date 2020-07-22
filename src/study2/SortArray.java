package study2;

import libs.SubstringCompatator;

import java.util.Arrays;

public class SortArray {
    public static void main(String[] args) {
        String[] strings = {"pfinful", "mbinly", "gaining", "reinrops"};

        Arrays.sort(strings, String.CASE_INSENSITIVE_ORDER);

        dump(strings,"Using Default Sort.");
        System.out.println("-------------------");

        Arrays.sort(strings, new SubstringCompatator());
        dump(strings, "Using SubstringComparator.");
    }

    static void dump(String[] args, String title) {
        System.out.println(title);
        for (int i = 0; i < args.length; i++)
            System.out.println(args[i]);
    }
}
