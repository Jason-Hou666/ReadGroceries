import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FormatGroceries {
    public static void main(String[] args) {
        String inputFile = "Groceries.txt";
        String outputFile = "FormattedGroceries.txt";
        
        try {
            List<String[]> groceries = readGroceries(inputFile);
            double total = calculateTotal(groceries);
            writeFormattedGroceries(outputFile, groceries, total);
            
            System.out.println("Formatting complete, results saved to: " + outputFile);
        } catch (IOException e) {
            System.out.println("Error occurred while processing file: " + e.getMessage());
        }
    }
    
    private static List<String[]> readGroceries(String filename) throws IOException {
        List<String[]> groceries = new ArrayList<>();
        
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            groceries.add(parts);
        }
        
        reader.close();
        return groceries;
    }
    
    private static double calculateTotal(List<String[]> groceries) {
        double total = 0;
        
        for (String[] item : groceries) {
            double quantity = Double.parseDouble(item[2]);
            double price = Double.parseDouble(item[3]);
            total += quantity * price;
        }
        
        return total;
    }
    
    private static void writeFormattedGroceries(String filename, List<String[]> groceries, double total) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        
        writer.write("*********************************************************");
        writer.newLine();
        writer.write(String.format("%-10s %-20s %-12s %-10s", "ID", "Item", "Quantity(KG)", "Price(€)"));
        writer.newLine();
        writer.write("*********************************************************");
        writer.newLine();
        
        for (String[] item : groceries) {
            writer.write(String.format("%-10s %-20s %-12s %-10s", 
                    item[0], item[1].trim(), item[2], item[3]));
            writer.newLine();
        }
        
        writer.write("*********************************************************");
        writer.newLine();
        writer.write(String.format("The grocery shopping total is: €%.2f", total));
        writer.newLine();
        writer.write("*********************************************************");
        
        writer.close();
    }
}