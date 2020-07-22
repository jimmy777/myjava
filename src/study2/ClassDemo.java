package study2;


class P {
    public P() {
        System.out.println("爷爷类的构造函数。");
    }

    @Override
    public String toString() {
        return "我是爷爷类。";
    }
}

class SubP extends P {
    public SubP() {
        System.out.println("父亲类的构造函数。");
    }

    @Override
    public String toString() {
        return "我是父类。";
    }
}

public class ClassDemo extends SubP {
    private int number;
    private String name;

    public ClassDemo() {
        System.out.println("子类的构造函数。");
    }

    public ClassDemo(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public ClassDemo(ClassDemo o) {
        this.number = o.number;
        this.name = o.name;
    }

    public static void main(String[] args) {
        /*
            1. 先调爷爷类，再调用父类，再掉本类的构造函数。
         */
//        ClassDemo c = new ClassDemo();
//        System.out.println(c);

        /*
            2. 父类的引用变量，定义时指向了一个子类。即把子类对象赋值给父类的变量，向上转型。
                这就是多态性的基本思想。
                向上转型，从一个较具体的类到较抽象的类的转换，这样总是安全的。
         */
//        Object c2 = new ClassDemo();
//        System.out.println(c2);

        /*
            3. 向下转型，一定要显式类型转换。
                即将抽象类型转换为具体的类型，这是不安全的，将丢失东西。
                向下转型前，通常用 instanceof 判断一下。否则会抛出 java.lang.ClassCastException 错误。
         */
//        P p3 = new SubP();
//        SubP sp3 = (SubP) p3;
//        System.out.println(sp3);

        /*
            4. instanceof 判断类实例
         */

//        P p4 = new P();
//        System.out.println(p4 instanceof P);
//        System.out.println(p4 instanceof SubP);
//        System.out.println(p4 instanceof ClassDemo);
//        System.out.println("-------------------------");
//
//        SubP sp4 = new SubP();
//        System.out.println(sp4 instanceof P);
//        System.out.println(sp4 instanceof SubP);
//        System.out.println(sp4 instanceof ClassDemo);
//        System.out.println("-------------------------");
//
//        ClassDemo c4 = new ClassDemo();
//        System.out.println(c4 instanceof P);
//        System.out.println(c4 instanceof SubP);
//        System.out.println(c4 instanceof ClassDemo);
//        System.out.println("-------------------------");
//
//        P p2 = new SubP();
//        if (p2 instanceof SubP) {
//            SubP sp2 = (SubP) p2;
//            System.out.println(sp2);
//        }

        /*
            5. 类的 toString、quauls 和 hashCode 方法重写
                - 哈希码是int类型的，所以允许出现负值；
                - 执行应用程序级清理的方法，finalize 方法和 addShutdownHook 方法；
         */

        P p1 = new P();
        P p2 = new SubP();
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
        System.out.println("--------------------------");

        System.out.println(p1.equals(p2));
        System.out.println("--------------------------");

        ClassDemo object1 = new ClassDemo(123, "Hello");
        ClassDemo object2 = new ClassDemo(object1);
        if (!object1.equals(object2))
            System.out.println("Something is terribly wrong...");
        System.out.println("All done.");

    }

    @Override
    public String toString() {
        // getClass 和 getName 是 Object 类继承的方法
        return "我是孩子类。在 " + getClass().getName() + " 类中重写了 toString 方法。";
    }
}
