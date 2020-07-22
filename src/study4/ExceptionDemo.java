package study4;

public class ExceptionDemo {

    static void pop() throws MyException {
        throw new MyException("这是 pop 方法的异常处理。");
    }

    public static void main(String[] args) {
//        int age = Integer.parseInt("20L"); // 抛 NumberFormatException
//        System.out.println(age);

        try {
            pop();
        } catch (MyException e) {
            e.printStackTrace();
        }

    }
}
