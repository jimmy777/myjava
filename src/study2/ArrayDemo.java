package study2;

public class ArrayDemo {
    public static void main(String[] args) {
        String[] s1 = {"a", "aa", "aaa"};
        int l = s1.length;

        String[] s2 = new String[l * 2];

        System.arraycopy(s1, 0, s2, 0, l);

        for (String ss : s2)
            System.out.println(ss);
    }
}
