package Exercise1;
import java.io.*;
import java.util.Arrays;

/**
 * Class: Data Analysis Program ITEC 2150 - 05
 *
 * author Dakota Sison Gregory
 * version 1.0
 * course ITEC 2150 Spring 2024
 * written April 11, 2024
 *
 * This class is designed to read a list of integers from a .txt file,
 * process them, and calculate various statistics like average, minimum, and maximum.
 * It includes exception handling to deal with issues like file not found or incorrect file format.
 */

public class CSVStatistics {

    public static void main(String[] args) {
        String inputFilePath = "src/Exercise1/Book1.txt"; // Replace with your txt file path
        String outputFilePath = "src/Exercise1/stats.txt"; // Replace with your desired output file path

        try {
            // Read from txt
            BufferedReader br = new BufferedReader(new FileReader(inputFilePath));
            String line = br.readLine();
            br.close();

            // Parse the Numbers
            String[] numberStrings = line.split(",");
            int[] numbers = Arrays.stream(numberStrings)
                    .mapToInt(Integer::parseInt)
                    .toArray();

            // Calculate Statistics
            int sum = Arrays.stream(numbers).sum();
            int min = Arrays.stream(numbers).min().orElseThrow();
            int max = Arrays.stream(numbers).max().orElseThrow();
            double average = Arrays.stream(numbers).average().orElseThrow();

            // Write to Text File
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath));
            bw.write("The sum of the numbers is: " + sum + "\n");
            bw.write("The lowest number is: " + min + "\n");
            bw.write("The highest number is: " + max + "\n");
            bw.write(String.format("The average of the numbers is: %.2f\n", average));
            bw.close();

            System.out.println("Statistics have been written to " + outputFilePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
