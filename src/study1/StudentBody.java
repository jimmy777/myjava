package study1;

import libs.Address;
import libs.Student;

public class StudentBody {
    public static void main(String[] args) {
        // 例子：7.3A SloganCounter
        // 功能：根据标语类 Slogan 创建实例，Slogan 类中的静态变量 count 来记录实例创建数，调用静态方法 getCount 查看。
        /*
        Slogan obj;

        obj = new Slogan("Remember the Alamo.");
        System.out.println(obj);

        obj = new Slogan("Don't Worry. Be Happy.");
        System.out.println(obj);

        obj = new Slogan("Live Free or Die.");
        System.out.println(obj);

        obj = new Slogan("Talk is Cheap.");
        System.out.println(obj);

        obj = new Slogan("Write Once. Run Anywhere.");
        System.out.println(obj);

        System.out.println();
        System.out.println("Slogans created: " + Slogan.getCount());
         */

        // 例子：7.4.2A RationalTester
        // 功能：一个有理数可以用两个整型数之比表示的值（分数）。
        // 说明：RationalNumber有理数；denominator 分母；numerator 分子；reciprocal 倒数；
        // reduce 和 gcd 方法是 private 私有的，类内部方法使用。不是为了提供对象服务，而仅仅是为了支持对象的其他服务。
        /*
        RationalNumber r1 = new RationalNumber(6, 8);
        RationalNumber r2 = new RationalNumber(1, 3);
        RationalNumber r3, r4, r5, r6, r7;

        System.out.println("First ratioanl number: " + r1);
        System.out.println("Second ratioanl number: " + r2);

        if (r1.isLike(r2))
            System.out.println("r1 and r2 are equal.");
        else
            System.out.println("r1 and r2 are NOT equal.");

        r3 = r1.reciprocal();
        System.out.println("The reciprocal of r1 is: " + r3);

        r4 = r1.add(r2);
        System.out.println("r1 + r2: " + r4);

        r5 = r1.subtract(r2);
        System.out.println("r1 - r2: " + r5);

        r6 = r1.multiply(r2);
        System.out.println("r1 * r2: " + r6);

        r7 = r1.divide(r2);
        System.out.println("r1 / r2: " + r7);
         */

        // 例子：7.4.3A StudentBody
        // 功能：类间的聚合关系。学生 Student 对象包含两个地址 Address 对象。
        Address school = new Address("800 Lancaster Ave.", "Villanova", "PA", 19085);

        Address jHome = new Address("21 Jump Street", "Blacksburg", "VA", 24551);
        Student john = new Student("John", "Smith", jHome, school);

        Address mHome = new Address("123 Main Street", "Euclid", "OH", 44132);
        Student marsha = new Student("Marsha", "Jones", mHome, school);

        System.out.println(john);
        System.out.println();
        System.out.println(marsha);

        // 结束
    }
}
