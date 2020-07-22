package study4;

/**
 * Created by yuanziyang on 2018/1/8.
 */

class LeiRenYuan {
    void crySpeak(String s) {
        System.out.println(s);
    }
}

class People extends LeiRenYuan {
    void computer(int a, int b) {
        int c = a * b;
        System.out.println("computer result: " + c);
    }

    void crySpeak(String s) {
        System.out.println("*** " + s + " ***");
    }
}

public class Example5_10 {
    public static void main(String args[]) {
        LeiRenYuan monkey;
        People geng = new People();
        monkey = geng;
        monkey.crySpeak("I love this game.");
        People people = (People) monkey;
        people.computer(10, 10);
    }
}
