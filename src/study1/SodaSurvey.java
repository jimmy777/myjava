package study1;

import java.text.DecimalFormat;

public class SodaSurvey {
    public static void main(String[] args) {

        // 例子：8.6B SodaSurvey

        // 四个 soda 饮料，十个 person 的评价。
        int[][] scores = {
                {3, 4, 5, 2, 1, 4, 3, 2, 4, 4},
                {2, 4, 3, 4, 3, 3, 2, 1, 2, 2},
                {3, 5, 4, 5, 5, 3, 2, 5, 5, 5},
                {1, 1, 1, 3, 1, 2, 1, 3, 2, 4}
        };

        final int SODAS = scores.length; // 四个饮料
        final int PEOPLE = scores[0].length; // 十个人

        int[] sodaSum = new int[SODAS]; // 一维数组
        int[] personSum = new int[PEOPLE]; // 一维数组

        for (int soda = 0; soda < SODAS; soda++)
            for (int person = 0; person < PEOPLE; person++) {
                sodaSum[soda] += scores[soda][person];
                personSum[person] += scores[soda][person];
            }

        DecimalFormat fmt = new DecimalFormat("0.#");
        System.out.println("Averages:\n");

        // 按四个饮料来统计。
        for (int soda = 0; soda < SODAS; soda++)
            System.out.println("Soda #" + (soda + 1) + ": " + fmt.format((float) sodaSum[soda] / PEOPLE));


        System.out.println();
        // 按十个人来统计。
        for (int person = 0; person < PEOPLE; person++)
            System.out.println("Peoson #" + (person + 1) + ": " + fmt.format((float) personSum[person] / SODAS));
    }
}
