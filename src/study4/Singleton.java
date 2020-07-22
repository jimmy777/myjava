package study4;

public class Singleton {
    private static Singleton instance;

    public Singleton() {
    }

    static {
        instance = new Singleton();
    }

    public static Singleton getInstance() {
        return instance;
    }

    public String demoMethod() {
        return "It's a Singleton Demo.";
    }
}
