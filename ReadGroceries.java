import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadGroceries {
    public static void main(String[] args) {
        String path = "Groceries.txt";
        
        try {
            FileReader fileread = new FileReader(path);
            BufferedReader reader = new BufferedReader(fileread);
            
            String line = reader.readLine();
            
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
            
            reader.close();
        } catch (IOException e) {
            System.out.println("Error occurred while reading file: " + e.getMessage());
        }
    }
}