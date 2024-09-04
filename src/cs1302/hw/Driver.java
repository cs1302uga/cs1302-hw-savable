package cs1302.hw;

import java.io.File;
import java.io.FileNotFoundException;
import cs1302.hw.impl.GameProgress;
import cs1302.hw.impl.TextBook;

/**
 * Tests the implementation of the {@code Savable} interface with multiple
 * implementing classes.
 */
public class Driver {

    /**
     * The main entry point of the application.
     *
     * @param args the command-line arguments.
     */
    public static void main(String[] args) {
        GameProgress game1 = new GameProgress(4000, 2);
        GameProgress game2 = new GameProgress(500, 3);

        // Saves an individual GameProgress object to a file called progressInfo.txt
        Driver.writeToFile(game1, "progressInfo.txt");

        GameProgress[] gpArray = new GameProgress[2];
        gpArray[0] = game1;
        gpArray[1] = game2;

        // Saves the array of GameProgress objects to files that start with "progress"
        Driver.writeAllToFile(gpArray, "progress");

        TextBook compilers = new TextBook("Compilers", "Addison Wesley");
        TextBook database = new TextBook("Database Systems", "Prentice Hall");
        TextBook systems = new TextBook("C++: How to Program", "Pearson");

        // Saves an individual GameProgress object to a file called compilersInfo.txt.
        // Uncomment the next line after updating writeToFile to work with TextBook objects.
        // Driver.writeToFile(compilers, "compilersInfo.txt");

        TextBook[] tbArray = new TextBook[3];
        tbArray[0] = compilers;
        tbArray[1] = database;
        tbArray[2] = systems;

        // Saves the array of TextBook objects to files that start with "book".
        // Uncomment after updating writeAllToFile to work with TextBook objects.
        // Driver.writeAllToFile(tbArray, "book");

    } // main

    /**
     * Writes (saves) a single {@code GameProgress} object to the file specified by
     * {@code filename}. This method invokes the {@code save} method on the provided
     * {@code object}.
     *
     * @param object the object to save.
     * @param filename the name of the file to write the data.
     */
    public static void writeToFile(GameProgress object, String filename) {
        try {
            File saveFile = new File(filename);
            // write the instance variables to a file using the save method in GameProgress
            object.save(saveFile);
        } catch (FileNotFoundException notFoundException) {
            System.err.println("Unable to save:");
            System.err.println(notFoundException.getMessage());
        } // try
    } // writeToFile

    /**
     * Writes (saves) an array of {@code GameProgress} objects to a set of files
     * whose names begin with {@code prefix}. Each object in the {@code objects}
     * array will be written to a separate file. The filename for a particular object
     * will be the {@code prefix} followed by the objects index in the array.
     *
     * @param objects the array of objects to save.
     * @param prefix the prefix for the filenames.
     */
    public static void writeAllToFile(GameProgress[] objects, String prefix) {
        for (int i = 0; i < objects.length; i++) {
            GameProgress object = objects[i];
            String filename = prefix + "" + i + ".txt";
            Driver.writeToFile(object, filename); // write a single object to a file
        } // for
    } // writeAllToFile
} // Driver
