package study1;

import libs.Season;

public class SeasonTester {
    public static void main(String[] args) {
        // 例子：7.6A SeasonTester
        // 功能：调用枚举类型的静态方法 values，遍历 Season 中的每个值，获得一个 Season 列表。列表是个迭代器，利用 for 来遍历。
        for (Season time: Season.values())
            System.out.println(time + "\t" + time.getSpan());
    }
}
