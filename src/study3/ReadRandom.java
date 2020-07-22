package study3;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ReadRandom {
    protected String fileName;
    protected RandomAccessFile seeker;

    public ReadRandom(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.seeker = new RandomAccessFile(fileName, "r");
    }

    public int readOffset() throws IOException {
        seeker.seek(0);
        return seeker.readInt();
    }

    public String readMessage() throws IOException {
        seeker.seek((readOffset()));
        return seeker.readLine();
    }
}
