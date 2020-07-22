package study4;

import java.io.*;
import java.util.zip.GZIPInputStream;

/**
 * 读 gz 文件。
 * gzip/gunzip 是解压缩工具；tar 是归档打包工具；gzip 一般与 tar 一起配合使用。
 * 解压缩 gzip 文件的方法：  GZIPInputStream  ->  InputStreamReader -> BufferedReader 对象。
 * 压缩创建 gzip 文件的方法：GZIPOutputStream -> DataOutputStream -> BufferedWriter 或者 PrintWriter 对象。
 */
public class ReadGZIP {
    public static void main(String[] args) throws IOException {
        final String FILENAME = "word.txt.gz";

        FileInputStream fin = new FileInputStream(FILENAME);
        GZIPInputStream gzis = new GZIPInputStream(fin);
        InputStreamReader isr = new InputStreamReader(gzis);
        // 处理文本内容，要是其他用字节流替换，即 BufferedInputStream 对象；
        BufferedReader is = new BufferedReader(isr);

        String line;

        while((line = is.readLine()) != null){
            System.out.println("Read: " + line);
        }

        is.close();
        isr.close();
        gzis.close();
        fin.close();

    }
}
