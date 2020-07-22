package libs;

// 基类
public class Book {
    // 可继承的变量 pages
    protected int pages = 1500;

    public void setPages(int numPages) {
        pages = numPages;
    }

    public int getPages() {
        return pages;
    }
}
