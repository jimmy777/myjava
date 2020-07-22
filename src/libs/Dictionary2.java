package libs;

public class Dictionary2 extends  Book2 {

    // 自己类的变量。
    private int definitions;

    public Dictionary2(int numPages, int numDefinitions) {
        // 构造方法不能被继承。所以使用 super 引用父类 Book 的构造方法。
        super(numPages);
        // 再初始化自己类声明的变量。
        definitions = numDefinitions;
    }

    public double computeRatio(){
        // 直接使用了父类的变量 pages
        return (double)definitions / pages;
    }

    public void setDefinitions(int numDefinitions){
        definitions = numDefinitions;
    }

    // 访问私有变量
    public int getDefinitions() {
        return definitions;
    }
}
