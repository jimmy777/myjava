package libs;

public class Slogan {
    private String phrase;
    // 声明静态变量 count
    private static int count = 0;

    // 创建实例时，调用了静态变量。
    public Slogan(String str){
        phrase = str;
        count++;
    }

    @Override
    public String toString() {
        return phrase;
    }

    // 静态方法调用静态变量 count，只能通过类名来调用，不能通过实例名来调用。
    // 注意：这个方法可以改为非静态方法，那样就需要创建一个实例来访问。
    public static int getCount(){
        return count;
    }
}
