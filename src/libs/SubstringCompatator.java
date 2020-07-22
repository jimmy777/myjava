package libs;

import java.util.Comparator;

public class SubstringCompatator implements Comparator<String> {
    String s1, s2;

    @Override
    public int compare(String o1, String o2) {
        s1 = o1.substring(1);
        s2 = o2.substring(1);
        return s1.compareTo(s2);
    }
}
