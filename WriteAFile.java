import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteAFile {
    public static void main(String[] args) {
        String writtenFile = "WriteAFileExample.txt";
        
        try {
            FileWriter filewrite = new FileWriter(writtenFile);
            BufferedWriter writer = new BufferedWriter(filewrite);
            
            writer.write("Hello, World!");
            writer.newLine();
            writer.write("This is the second line");
            writer.newLine();
            writer.write("This is the third line");
            
            writer.close();
            
            System.out.println("File has been successfully written: " + writtenFile);
        } catch (IOException e) {
            System.out.println("Error occurred while writing to file: " + e.getMessage());
        }
    }
}