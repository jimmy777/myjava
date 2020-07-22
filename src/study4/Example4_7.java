package study4;

/**
 * Created by yuanziyang on 2018/1/27.
 */
public class Example4_7 {
    public static void main(String args[]) {
        Battery nanfu = new Battery(100);
        System.out.println("电池引用:" + nanfu);
        System.out.println("南孚电池电量: " + nanfu.electricityAmount +
                "\n=========================================");

        Radio radio = new Radio();
        System.out.println("收音机引用:" + radio);
        System.out.println("打开收音机,开始使用电池!");
        radio.openRadio(nanfu);
        System.out.println("电池当前电量: " + nanfu.electricityAmount +
                "\n=========================================");

        Radio radio2 = new Radio();
        System.out.println("收音机引用:" + radio2);
        System.out.println("打开收音机,开始使用电池!");
        radio2.openRadio(nanfu);
        System.out.println("电池当前电量: " + nanfu.electricityAmount);
    }
}
