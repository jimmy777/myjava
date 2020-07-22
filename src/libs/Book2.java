package libs;

public class Book2 {
    // 基类的变量 pages，可供子类使用。但为被初始化。
    protected int pages;

    // 自己类的构造函数，初始化 pages。
    public Book2(int numPages){
        pages = numPages;
    }

    public void setPages(int numPages) {
        pages = numPages;
    }

    public int getPages() {
        return pages;
    }
}
