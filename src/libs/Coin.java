package libs;

/**
 * Created by yuanziyang on 2020/2/8.
 */
public class Coin {
    /*
     HEADS 和 TAILS 两个常量表示硬币的两个面;
     face 变量表示当前面;
     flip 方法来掷硬币;
      */
    private final int HEADS = 0;
    private final int TAILS = 1;

    private int face;

    public Coin(){
        flip();
    }

    public void flip() {
        face = (int)(Math.random() * 2);
    }

    public boolean isHeads() {
        return (face == HEADS);
    }

    @Override
    public String toString() {
        String faceName;
        if (face == HEADS)
            faceName = "Heads";
        else
            faceName = "Tails";
        return faceName;
    }
}
