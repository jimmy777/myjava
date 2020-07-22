
package libs;

// Pizza 继承父类 FoodItem
public class Pizza extends FoodItem {

    // 调用构造函数
    public Pizza(int fatGrams) {
        // 调用父类 FoodItem 的构造函数。
        super(fatGrams, 8);
    }
}
