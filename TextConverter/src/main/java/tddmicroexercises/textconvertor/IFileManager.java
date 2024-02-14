package tddmicroexercises.textconvertor;

public interface IFileManager {

    String readLine();
    String getFilename();
    void close();
    long skip(int n);

}
