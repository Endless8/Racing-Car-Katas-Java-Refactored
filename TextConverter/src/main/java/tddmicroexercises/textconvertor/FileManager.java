package tddmicroexercises.textconvertor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class FileManager implements IFileManager {

    BufferedReader reader;
    String fullFilenameWithPath;

    FileManager(String fullFilenameWithPath) {
        this.fullFilenameWithPath = fullFilenameWithPath;
        try {
            reader = new BufferedReader(new FileReader(fullFilenameWithPath));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getFilename() {
        return this.fullFilenameWithPath;
    }

    @Override
    public void close() {
        try {
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public long skip(int n) {
        try {
            return reader.skip(n);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
