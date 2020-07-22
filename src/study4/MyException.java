package study4;

public class MyException extends Exception {

    private String message;

    public MyException(String ErrorMessage){
        this.message = ErrorMessage;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
