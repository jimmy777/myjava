package study3;

import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class IODemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

//        readByteData();
//        readOtherData();
//        readLineData();
//        readLineIntData();
//        readConsoleData();
//        readPrintData();
//        readFormatData();

//        writeBinaryData();
//        readRandomData();
        writeSerialData();
    }

    /**
     * 1. System.in.read() 一次读取一个字节
     */
    public static void readByteData() {
        try {
            int b = System.in.read(); // 只读取一个字节的数据
            System.out.println(b); // 打印整数
            System.out.println((char) b); // 转换成字符
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 2. Scanner 对象来扫描数据，如整数类型的数据。
     */
    public static void readOtherData() {

        Scanner sc = new Scanner(System.in);

        try {
            int i = sc.nextInt(); // 一次读取整数值
            System.out.println(i);
        } catch (
                InputMismatchException e) {
            System.out.println(e);
        }
    }


    /**
     * 3. 每次读取一行数据进行处理。
     */
    public static void readLineData() {
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));

            String line;
            while ((line = is.readLine()) != null) {
                System.out.println(line);
            }
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 4. 读取整数
     */
    public static void readLineIntData() {
        BufferedReader is = new BufferedReader(new InputStreamReader(System.in));

        String line;
        int val = 0;

        try {
            line = is.readLine();  // 读取字符串

            val = Integer.parseInt(line); // 字符串转换为整数。还可以用 DecimalFormat 进行转换。
            System.out.println("I read this number: " + val);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 5. System.console() 得到控制台对象；
     */

    public static void readConsoleData() {
        Console cons;

        // 一般使用 console 对象前要判断一下。
        if ((cons = System.console()) != null) {
            char[] passwd = null;
            try {
                passwd = cons.readPassword("请输入Password: ");
                System.out.println("你输入的密码是： " + new String(passwd));
            } finally {
                // 安全考虑，用完即覆盖掉。
                if (passwd != null) {
                    java.util.Arrays.fill(passwd, ' ');
                }
            }
        } else {
            throw new RuntimeException("No console, can't get password.");
        }
    }

    /**
     * 6. PrintStream 类
     */
    public static void readPrintData() {
        PrintWriter pw = new PrintWriter(System.out);
        pw.println("Hello world of java.");
    }

    /**
     * 7. printf 格式化输出
     */
    public static void readFormatData() {
        // $1 为第1个值，$2 为第2个值；
        System.out.printf("%1$04d - the year of %2$f%n", 1956, PI);
        System.out.println("-------------------------");

        Formatter fmtr = new Formatter();
        Object result = fmtr.format("%1$04d - the year of %2$f%n", 1956, PI);
        System.out.print(result);
        System.out.println("-------------------------");

        String stringResult = String.format("%1$04d - the year of %2$f%n", 1956, PI);
        System.out.print(stringResult);
        System.out.println("-------------------------");

        System.out.printf("%4d-%02d-%02d%n", 2014, 6, 28);
        System.out.println("-------------------------");

        Date today = Calendar.getInstance().getTime();
        System.out.printf("Today is: %1$tB %1$td %1$tY%n", today);

    }

    /**
     * 8. 读写二进制数据
     */
    public static void writeBinaryData() throws IOException {
        String FILENAME = "binary.dat";

        DataOutputStream os = new DataOutputStream(new FileOutputStream(FILENAME));

        int i = 42;
        double d = PI;

        os.writeInt(42);
        os.writeDouble(d);

        os.close();
    }

    /**
     * 9. 利用 RandomAccessFile
     */

    public static void readRandomData() throws IOException {
        final String FILENAME = "random.dat";

        ReadRandom r = new ReadRandom(FILENAME);

        System.out.println("Offset is " + r.readOffset());
        System.out.println("Message is \" "+ r.readMessage() + "\"." );
    }

    /**
     * 10. 类实现 Serializable 接口，可以序列化。
     */
    public static void writeSerialData() throws IOException, ClassNotFoundException {
        MyData person = new MyData("jimmy", "123456");

        ObjectOutputStream os = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("serial.dat")));

        os.writeObject(person);
        os.close();

        ObjectInputStream is = new ObjectInputStream(new FileInputStream("serial.dat"));
        System.out.println(is.readObject());
        is.close();
    }



}


