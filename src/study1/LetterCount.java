package study1;

import java.util.Scanner;

public class LetterCount {

    // 例子：8.2B LetterCount 字母统计
    // 功能：大小写字母统计。
    public static void main(String[] args) {
        final int NUMCHARS = 26;

        Scanner scan = new Scanner(System.in);

        // 26 个字母，默认值为0。
        int[] upper = new int[NUMCHARS];
        int[] lower = new int[NUMCHARS];

        char current;
        int other = 0; // 其他字符

        System.out.println("Enter a sentence:");
        String line = scan.nextLine();

        for (int ch = 0; ch < line.length(); ch++) {
            current = line.charAt(ch);
            if (current >= 'A' && current <= 'Z') {
                // 相对于字母 A 的位置，正好为数组的索引值。
                upper[current - 'A']++;
            } else
                if (current >= 'a' && current <= 'z')
                    // 相对于字母 a 的位置，正好为数组的索引值。
                    lower[current - 'a']++;
                else
                    other++;
        }

        System.out.println();
        for (int letter = 0; letter < upper.length; letter++) {
            System.out.print((char) (letter + 'A'));
            System.out.print(": " + upper[letter]);
            System.out.print("\t\t" + (char) (letter + 'a'));
            System.out.println(": " + lower[letter]);
        }

        System.out.println();
        System.out.println("Non-alphabetic characters: " + other);
    }
}
