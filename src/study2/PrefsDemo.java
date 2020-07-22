package study2;

import java.io.IOException;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class PrefsDemo {
    public static void main(String[] args) throws IOException, BackingStoreException {
        // 程序偏好文件
        Preferences preferences = Preferences.userNodeForPackage(PrefsDemo.class);

        // 预定义一些配置，如字体
        String textFontName = preferences.get("textFontName", "lucida-bright");
        System.out.println(textFontName);

        // 用户自定义一些配置，如字体
        preferences.put("textFontName", "times-roman");

        Preferences node = preferences.node("a/b");
        node.putInt("meaning", 42);
        node.putDouble("pi", Math.PI);

        preferences.exportSubtree(System.out);
    }
}
