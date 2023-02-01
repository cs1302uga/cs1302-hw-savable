package cs1302.hw03;

import java.io.File;
import java.io.FileNotFoundException;
import cs1302.hw03.impl.GameProgress;

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
        GameProgress game1 = new GameProgress(4_000, 2);
        GameProgress game2 = new GameProgress(20_000, 3);
        GameProgress[] gpArray = new GameProgress[2];
        gpArray[0] = game1;
        gpArray[1] = game2;
        Driver.saveAll(gpArray, "progress");

        // TODO: Create 3 Textbook objects, add them to an array, call saveAll
        // Do not add any methods. Modify the existing methods to make this work.

    } // main

    // TODO: Add Javadoc Comments
    public static void save(GameProgress object, String filename) {
        try {
            File saveFile = new File(filename);
            object.save(saveFile);
        } catch (FileNotFoundException notFoundException) {
            System.err.println("Unable to save:");
            System.err.println(notFoundException.getMessage());
        } // try
    } // save

    private static void saveAll(GameProgress[] objects, String prefix) {
        for (int i = 0; i < objects.length; i++) {
            GameProgress object = objects[i];
            String filename = prefix + "" + i + ".txt";
            Driver.save(object, filename);
        } // for
    } // saveAll
} // Driver
