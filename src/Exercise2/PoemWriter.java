package Exercise2;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Class: Poem Writing Program ITEC 2150 - 05
 *
 * author Dakota Sison Gregory
 * version 1.0
 * course ITEC 2150 Spring 2024
 * written April 11, 2024
 *
 * This class is designed to write details of various poems to a text file.
 * It creates multiple Poem objects, each representing a specific poem, and writes their details
 * such as the poem's name and poet's name to a designated file.
 * The class handles file writing operations and ensures proper management of file resources,
 * encapsulating the writing logic in a private method to maintain clean and manageable code.
 */

public class PoemWriter {

    /**
     * Initializes Poem objects, sets their attributes, and writes their details to a text file.
     * leverages a helper method to write each poem's details, ensuring that the file output is formatted
     * correctly and includes necessary separations between entries.
     * Exception handling is used to manage potential I/O errors such as file access issues, ensuring the program
     * can inform the user of such problems and prevent data loss.
     */

    public static void main(String[] args) {
        // Create three Poem objects
        Poem poem1 = new Poem();
        poem1.setName("The Road Not Taken");
        poem1.setPoet("Robert Frost");

        Poem poem2 = new Poem();
        poem2.setName("Still I Rise");
        poem2.setPoet("Maya Angelou");

        Poem poem3 = new Poem();
        poem3.setName("If");
        poem3.setPoet("Rudyard Kipling");

        // The file path for poems.txt - make sure to use the correct path for your system
        String outputPath = "src/Exercise2/poems.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {
            // Write the poems to the text file
            writePoem(writer, poem1);
            writePoem(writer, poem2);
            writePoem(writer, poem3);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Poems have been written to " + outputPath);
    }

    /**
     * Writes a Poem object's details to a BufferedWriter.
     * This method formats each poem's name followed by the poet's name,
     * separating each poem entry with a blank line for clarity.
     */

    private static void writePoem(BufferedWriter writer, Poem poem) throws IOException {
        writer.write(poem.getName());
        writer.newLine();
        writer.write(poem.getPoet());
        writer.newLine();
        writer.newLine(); // Add an extra newline for separation between poems
    }
}

