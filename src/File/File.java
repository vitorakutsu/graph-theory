package File;

import java.io.IOException;
import java.io.RandomAccessFile;

public class File {
    public String pathFile;

    public File(String pathFile) {
        this.pathFile = pathFile;
    }

    public int getNumberOfLines() throws IOException {
        RandomAccessFile file = new RandomAccessFile(this.pathFile, "r");
        int lines = 0;
        while (file.readLine() != null) {
            lines++;
        }
        file.close();
        return lines;
    }

    public int getNumberOfColumns() throws IOException {
        RandomAccessFile file = new RandomAccessFile(this.pathFile, "r");
        String firstLine = file.readLine();
        file.close();

        if (firstLine != null) {
            return firstLine.split(",").length;
        } else {
            return 0;
        }
    }
}
