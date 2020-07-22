package study4;

import java.io.File;
import java.io.IOException;
import java.io.Writer;

/**
 * 例子，保存少量用户偏好数据到文件。
 */
public class FileSaverDemo {
    public static void main(String[] args) throws IOException, IllegalAccessException {
        FileSaver fs = new FileSaver(new File("abc.txt"));
        Writer writer = fs.getWriter();
        writer.write("hello world of java.");
        writer.close();
        fs.finish();
    }
}
