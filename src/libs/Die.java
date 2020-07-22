package libs;

public class Die {
    private final int MAX = 6;
    private int faceValue;

    public Die() {
        faceValue = 1;
    }

    // println方法会显示的字符串
    public String toString() {
        String result = Integer.toString(faceValue);
        return result;
    }

    public int roll() {
        faceValue = (int)(Math.random() * MAX) + 1;
        return faceValue;
    }

    public int getFaceValue() {
        return faceValue;
    }


    public void setFaceValue(int i) {
        faceValue = i;
    }
}
