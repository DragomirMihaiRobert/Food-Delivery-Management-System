package data;

import java.io.IOException;

public class FileWriter {
    private java.io.FileWriter fileWriter;
    private boolean isClosed = false;
    public FileWriter(String fileName) throws IOException {
        fileWriter = new java.io.FileWriter(fileName);
    }
    public void write(String text) throws IOException {
        fileWriter.write(text);
    }
    public void close() throws IOException {
        fileWriter.close();
        isClosed = true;
    }

    public boolean isClosed() {
        return isClosed;
    }
}
