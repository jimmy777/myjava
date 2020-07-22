package libs;

// 自定义一个异常类，继承至 Exception 类。
public class OutOfRangeException extends Exception {
    public OutOfRangeException(String message){
        super(message);
    }
}
