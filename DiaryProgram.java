import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DiaryProgram {
    public static void main(String[] args) {
        String diaryFile = "Diary.txt";
        
        try {
            FileWriter filewrite = new FileWriter(diaryFile);
            BufferedWriter writer = new BufferedWriter(filewrite);
            Scanner scanner = new Scanner(System.in);
            
            System.out.println("Please start entering your diary content (type END or end to finish):");
            
            String input;
            while (true) {
                input = scanner.nextLine();
                
                if (input.equalsIgnoreCase("END")) {
                    break;
                }
                
                writer.write(input);
                writer.newLine();
            }
            
            writer.close();
            scanner.close();
            
            System.out.println("Diary has been saved to file: " + diaryFile);
        } catch (IOException e) {
            System.out.println("Error occurred while writing to file: " + e.getMessage());
        }
    }
}