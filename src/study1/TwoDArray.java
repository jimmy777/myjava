package study1;

public class TwoDArray {

    // 例子：8.6A TwoDArray
    public static void main(String[] args) {
        int[][] table = new int[5][10];

        // 外循环次数 row 由 table.length 来控制。
        for (int row = 0; row < table.length; row++)
            for (int col = 0; col < table[row].length; col++)
                table[row][col] = row * 10 + col;
        // 内循环次数 col 由 table[row].length 来控制。
        for (int row = 0; row < table.length; row++) {
            for (int col = 0; col < table[row].length; col++)
                System.out.print(table[row][col] + "\t");
            System.out.println();
        }
    }
}
