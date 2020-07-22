package study2;

import java.util.Date;
import java.util.Iterator;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
    String 对象
 */
public class StringDemo {

    public static void main(String[] args) {

        /*
            分隔符，获取单词。
            比较一下 String.split 和 StringTokenizer 两者方式。
            StringTokenizer 经常被正则表达式替换。
         */

//        String str = new String("Hello World  of   Java");
//        for (String s: str.split(" "))
//            System.out.println(s);
//
//        System.out.println("-----------------");
//        StringTokenizer st = new StringTokenizer(str);
//        while (st.hasMoreTokens()) {
//            System.out.println("Token: " + st.nextToken());
//        }
//
//        System.out.println("-----------------");
//        StringTokenizer st2 = new StringTokenizer("Hello| World | of  | Java", "|");
//        while (st2.hasMoreElements())
//            System.out.println("Token: " + st2.nextElement());

        /*
            Pattern.compile
         */
//        String str = new String("Hello World 1 of  2 Java");
//        Matcher toke = Pattern.compile("\\d+").matcher(str);
//        Matcher toke = Pattern.compile("\\w+").matcher(str);
//        while (toke.find()) {
//            String g = toke.group(0);
//            System.out.println(g);
//            int i = Integer.parseInt(g);
//            System.out.println(i);
//        }

        /*
            toCharArray
         */
//        String str = new String("Hello World of Java");
//        for (char c: str.toCharArray())
//            System.out.println(c);
        /*
            StringBuilder 优于 StringBuffer；
            String 拼接的时候要快一些；
         */
//        StringBuffer sb = new StringBuffer();
//        sb.append("A");
//        System.out.println(sb.toString());

        /*
            利用 StringTokenizer 和 Stack 实现字符串翻转。

            StringTokenizer is a legacy class that is retained for compatibility reasons although its use is discouraged in new code. It is recommended that anyone seeking this functionality use the split method of String or the java.util.regex package instead.
            谷歌翻译:StringTokenizer是一个遗留类，出于兼容性原因而保留，尽管在新代码中不鼓励使用它。 建议任何寻求此功能的人都使用String的split方法或java.util.regex包。
         */

//        String str = new String("Hello World of Java.");
//
//        Stack<String> myStack = new Stack<String>();
//        StringTokenizer st = new StringTokenizer(str);
//        while (st.hasMoreTokens())
//            myStack.push(st.nextToken());
//
//        while (!myStack.isEmpty())
//            System.out.println(myStack.pop());

        /*

         */



        /*
            1. String 对象是固定长度，不能修改
            StringBuilder 对象，可变长度，方便添加、修改和删除操作。append、insert、delete
         */
//        StringBuilder builder = new StringBuilder("");
//        builder.append("hello\n");
//        builder.append("world");
//        System.out.println(builder.toString());

        /*
            2. 正则表达式
         */
//        String regex = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
//        String regex = "\\w+@\\w+(\\w+.)\\w+";
//        String s1 = "test@abc.com";
//        if (s1.matches(regex))
//            System.out.println("正则检查1：是电子邮箱。");
//        else
//            System.out.println("正则检查1：不是电子邮箱。");
//
//        if (isEmail(s1))
//            System.out.println("正则检查2：是电子邮箱。");
//        else
//            System.out.println("正则检查1：不是电子邮箱。");

        /*
            3. 格式化字符串
         */
//        String str = String.format("%d", 400/2);
//        System.out.println(str);
//        System.out.println(String.format("%x", 200));
//
//        Date date = new Date();
//        System.out.println(String.format("全显： %tc",date));
//
//        System.out.println(String.format("日期： %tF",date));
//        System.out.println(String.format("年： %tY",date));
//        System.out.println(String.format("月： %tm %tB",date, date));
//        System.out.println(String.format("日： %td",date));
//
//        System.out.println(String.format("小时： %tH",date));
//        System.out.println(String.format("分钟： %tM",date));
//        System.out.println(String.format("秒：   %tS",date));
//        System.out.println(String.format("毫秒：   %tL",date));

        /*
            4. 字符串分隔 split
         */

//        String str = new String("hello, how are you? fine, thank you.");
//        String[] sp = str.split(",");
//        String[] sp = str.split(" ");
//        String[] sp = str.split(" ", 2);
//
//        for (String s: sp)
//            System.out.println(s);

        /*
            5. 转换大小写
         */
//        String str = new String("Hello, How are you? Fine, Thank you.");
//        System.out.println(str.toUpperCase());
//        System.out.println(str.toLowerCase());

        /*
            6. 字符串比较
         */
//        String s1 = new String("abc");
//        String s2 = new String("bac");
//        String s3 = new String("cba");
//        String s11 = new String("aBc");
//
//        System.out.println(s1.compareTo(s2)); // s1在s2之前
//        System.out.println(s3.compareTo(s2)); // s3在s2之后
//        System.out.println(s2.compareTo(s2)); // 相等
//
//        System.out.println(s1.equals(s11)); // 判断是否相等，false
//        System.out.println(s1.equalsIgnoreCase(s11)); // 判断时忽略大小写

        /*
            7. 判断字符串首、尾字符串
         */
//        String str = new String("123abc");
//
//        System.out.println(str.startsWith("12"));
//        System.out.println(str.startsWith("21"));
//
//        System.out.println(str.endsWith("bc"));
//        System.out.println(str.endsWith("cb"));

        /*
            6. 字符串替换
         */
//        String str = new String("hi, hello.");
//        System.out.println(str.replace("h", "H"));

        /*
            5. 去空格
         */
//        String str = new String(" Hello, abc.    ");
//        System.out.println(str.length());
//        System.out.println(str.trim().length());

        /*
            4. 获取子串
         */
//        String str = new String("hello world.");
//        System.out.println(str.substring(1)); // 截取开始位置到结束
//        System.out.println(str.substring(0,5)); // 截取开始位置到结束

        /*
            3. 获取指定索引位置的字符
         */
//        String str = new String("hello world.");
//        System.out.println(str.charAt(1));

        /*
            2. 字符串查找
         */
//        String str = new String("hello world.");
//        System.out.println(str.indexOf('a'));
//        System.out.println(str.indexOf('o'));
//        System.out.println(str.lastIndexOf('o'));

        /*
            1. 连接字符串 +
                字符串连接其他类型时，自动调用 toString() 方法。
         */
//        String str = new String("abc");
//        System.out.println(str + 123);

        /*
            字符串的声明和定义
         */
//        char a[] = {'h', 'e', 'l', 'l', 'o'};
//        String str = null;
//        String str = "";
//        String str1 = new String(a);
//        String str2 = new String(a,1,2);
//
//        System.out.println(str.isEmpty());
//        System.out.println(str1 + "\n" + str2);

    }

    public static boolean isEmail(String email) {
        if (null == email || "".equals(email)) return false;
//        Pattern p = Pattern.compile("\\w+@(\\w+.)+[a-z]{2,3}"); //简单匹配
        Pattern p = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");//复杂匹配
        Matcher m = p.matcher(email);
        return m.matches();
    }


}
