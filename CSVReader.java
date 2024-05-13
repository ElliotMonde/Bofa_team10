import java.io.*;
import java.util.Scanner;

public class CSVReader{
    public String[] ls;
    public Scanner sc;

    private void setScanner(String filename) throws Exception {
        sc = new Scanner(new File("test-set/" + filename));
    }
    
    public Scanner parseCSV(String filename) {
        try {
            setScanner(filename);
        } catch (Exception e) {
            System.err.println("file not found.");
        }
        sc.useDelimiter(", ");
        return sc;
    }
}