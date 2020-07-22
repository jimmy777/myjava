package libs;

import libs.Num;

public class ParameterModifier {
    public void changeValues(int f1, Num f2, Num f3) {
        System.out.println("Before changing the values:");
        System.out.println("f1\tf2\tf3");
        System.out.println(f1 + "\t" + f2 + "\t" + f3 + "\n");

        f1 = 999; // 实参的一个副本传给了形参，所以不影响实参。
        f2.setValue(888); // 形参与实参指向同一个 Num 对象，这时对对象的修改会影响实参。
        f3 = new Num(777); // 形参指向了一个新的 Num 对象，所以不影响实参。

        System.out.println("After changing the values:");
        System.out.println("f1\tf2\tf3");
        System.out.println(f1 + "\t" + f2 + "\t" + f3 + "\n");

    }
}
