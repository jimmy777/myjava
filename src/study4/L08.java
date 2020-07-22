package study4;

public class L08 {
    public static void main(String[] args) {
        /*
            1. enum 枚举类的例子
         */
        // 显示枚举值
//        MediaDemo demo = new MediaDemo("Hello world", Media.BOOK);
//        System.out.println(demo);
        // 遍历枚举的值
//        for (Media m: Media.values())
//            System.out.println(m);

        /*
            2. Singleton 例子
         */
        Singleton instance = Singleton.getInstance();
        String str = instance.demoMethod();
        System.out.println(str);
    }
}
