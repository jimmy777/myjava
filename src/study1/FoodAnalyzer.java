package study1;

import libs.Pizza;

public class FoodAnalyzer {
    // 例子：9.4A FoodAnalyzer

    public static void main(String[] args) {

        // 创建一个 Pizza 对象
        Pizza special = new Pizza(275);
        System.out.println("Calories per serving: "+ special.caloriesPerServing());
    }
}
