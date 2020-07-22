package study4;

import java.io.*;

/**
 * 保存文件的操作
 * 生成 .tmp 和 .bak 文件，文件处理完之后进行清理操作。
 */
public class FileSaver {

    private enum State {
        /**
         * 使用前后的状态
         */
        AVAIABLE,
        /**
         * 使用中的状态
         */
        INSUSE
    }

    private State state;
    private final File inputFile;
    private final File tmpFile;
    private final File backupFile;

    public FileSaver(File inputFile) throws IOException {
        this.inputFile = inputFile;
        tmpFile = new File(inputFile.getAbsolutePath() + ".tmp");
        tmpFile.createNewFile();
        tmpFile.deleteOnExit();
        backupFile = new File(inputFile.getAbsolutePath() + ".bak");
        state = State.AVAIABLE;
    }

    public File getFile() {
        return inputFile;
    }

    public OutputStream getOutputStream() throws IllegalAccessException, FileNotFoundException {
        if (state != State.AVAIABLE) {
            throw new IllegalStateException("FileSaver not opened.");
        }
        OutputStream out = new FileOutputStream(tmpFile);
        state = State.INSUSE;
        return out;
    }

    public Writer getWriter() throws IllegalAccessException, IOException {
        if (state != State.AVAIABLE) {
            throw new IllegalStateException("FileSaver not opened.");
        }
        Writer out = new FileWriter(tmpFile);
        state = State.INSUSE;
        return out;
    }

    public void finish() throws IOException {
        if (state!=State.INSUSE){
            throw new IllegalStateException("FileSaver not in use.");
        }
        backupFile.delete();
        if (inputFile.exists() && !inputFile.renameTo(backupFile)){
            throw new IOException("Could not rename file to backup file.");
        }
        if (!tmpFile.renameTo(inputFile)){
            throw new IOException("Could not rename temp file to save file.");
        }
        state = State.AVAIABLE;
    }

}
