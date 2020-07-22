package study4;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileDemo {
    public static void main(String[] args) {
        File file = new File("word.txt");
        if (file.exists()) {
            file.delete();
            System.out.println("文件已删除。");
        } else {
            try {
                file.createNewFile();
                System.out.println("文件已创建。");
                // 方法1：byte[]
//                writeFile(); // FileOutputStream 对象写入数据（字节byte或字节数组byte[]）到文件
//                getFileInfo(); // File 对象获取文件信息
//                readFile(); // FileInputStream 对象读文件内容

                // 方法2：String
//                writeText(); // FileWriter 对象写入字符串 String 到文件
//                getFileInfo(); // File 对象获取文件信息
//                readText(); // FileReader 对象读文件内容

                // 方法3：buffer
//                bufferedWriteText();
//                getFileInfo();
//                bufferedReadText();

                // 方法4：DataOutputStream 对象
//                dataWriteText();
//                getFileInfo();
//                dataReadText();

                // 方法5：Zip 压缩文件
                zipOutputStream();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void getFileInfo() {
        File file = new File("word.txt");
        if (file.exists()) {
            String name = file.getName();
            long length = file.length();
            boolean hidden = file.isHidden();

            System.out.println("文件名：" + name);
            System.out.println("文件长度是：" + length);
            System.out.println("该文件是隐藏文件吗？" + hidden);
        } else {
            System.out.println("该文件不存在。");
        }
    }

    public static void writeFile() {
        File file = new File("word.txt");

        try {
            FileOutputStream out = new FileOutputStream(file);

            byte[] data = "Java 开发指南".getBytes();

            out.write(data);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFile() {
        File file = new File("word.txt");

        try {
            FileInputStream in = new FileInputStream(file);
            byte[] buffer = new byte[1024];
            int len = in.read(buffer);
            System.out.println("文件中的内容是：" + new String(buffer, 0, len));
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeText() {
        File file = new File("word.txt");

        try {
            FileWriter out = new FileWriter(file);
            String str = "Java 入门与精通";
            out.write(str);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readText() {
        File file = new File("word.txt");

        try {
            FileReader in = new FileReader(file);
            char[] buffer = new char[1024];
            int len = in.read();
            System.out.println("文件中的内容是：" + new String(buffer, 0, len));
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void bufferedWriteText() {
        String[] data = {"好久不见", "最近好吗", "常联系"};

        File file = new File("word.txt");

        try {
            FileWriter fw = new FileWriter(file);

            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 0; i < data.length; i++) {
                bw.write(data[i]);
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void bufferedReadText() {
        File file = new File("word.txt");

        try {
            FileReader fr = new FileReader(file);

            BufferedReader br = new BufferedReader(fr);

            String data = null;
            int i = 0;

            while ((data = br.readLine()) != null) {
                i++;
                System.out.println("第" + i + "行： " + data);
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void dataWriteText() {
        try {
            FileOutputStream fos = new FileOutputStream("word.txt");
            DataOutputStream dos = new DataOutputStream(fos);
            dos.writeUTF("Java 入门与精通（第三版）");
            dos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void dataReadText() {
        String data = null;
        try {
            FileInputStream fis = new FileInputStream("word.txt");
            DataInputStream dis = new DataInputStream(fis);
            data = dis.readUTF();
            System.out.print(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void zip(String zipFilName, File inputFile) throws IOException {
        FileOutputStream fos = new FileOutputStream(zipFilName);
        ZipOutputStream zos = new ZipOutputStream(fos);
        zip(zos, inputFile, "");
        System.out.println("压缩中...");
        zos.close();
    }

    private static void zip(ZipOutputStream zos, File file, String base) throws IOException {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            zos.putNextEntry(new ZipEntry(base + "/"));
            base = base.length() == 0 ? "" : base + "/";
            for (int i = 0; i < files.length; i++) {
                zip(zos, files[i], base + files[i]);
            }
        } else {
            zos.putNextEntry(new ZipEntry(base));
            FileInputStream fis = new FileInputStream(file);
            int b;
            System.out.println(base);
            while ((b=fis.read())!=-1){
                zos.write(b);
            }
            fis.close();
        }
    }

    public static void zipOutputStream() {
        try {
            zip("temp.zip",new File("temp"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
