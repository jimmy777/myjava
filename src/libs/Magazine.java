package libs;

public class Magazine {
    // 封装很好，没有包含下一个 Magazine 对象引用，所以保持了独立性。
    private String title;

    public Magazine(String newTitle){
        title = newTitle;
    }

    @Override
    public String toString() {
        return title;
    }
}
