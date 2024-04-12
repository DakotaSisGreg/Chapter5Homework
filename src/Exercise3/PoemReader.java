package Exercise3;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Class: Creative Writing Program ITEC 2150 - 05
 *
 * author Dakota Sison Gregory
 * version 1.0
 * course ITEC 2150 Spring 2024
 * written April 11, 2024
 *
 * This class is designed to read and display poem details from a text file.
 * It reads the poem's name and the poet's name from the file and prints each poem as an object.
 * The class handles file reading operations and ensures proper management of file resources.
 *  */


public class PoemReader {

    public static void main(String[] args) {
        String inputPath = "src/Exercise3/poem2.txt"; // The file path for poem2.txt - make sure to use the correct path for your system

        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath))) {
            String poemName;
            while ((poemName = reader.readLine()) != null) { // Read the poem name
                String poetName = reader.readLine(); // Immediately read the next line as the poet name
                if (poetName != null) {
                    Poem poem = new Poem();
                    poem.setName(poemName);
                    poem.setPoet(poetName);
                    System.out.println(poem); // Print the poem object using its toString method
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
