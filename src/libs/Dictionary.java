package libs;

// 子类，继承了父类的一个变量和两个方法。
public class Dictionary extends Book {
    // 私有变量
    private int definitions = 52500;

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
