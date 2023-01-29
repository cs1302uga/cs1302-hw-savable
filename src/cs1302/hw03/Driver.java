package cs1302.hw03;

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


    } // main

    public static void save(GameProgress object, String prefix) {


    } // test

    private static void saveAll(GameProgress[] objects, String prefix) {
        for (int i = 0; i < objects.length; i++) {
            try {
                Savable object = objects[i];
                String filename = String.format("%s%d.txt", prefix, i);
                File saveFile = new File(filename);
                object.save(saveFile);
            } catch (FileNotFoundException notFoundException) {
                System.err.println("Unable to save:");
                System.err.println(notFoundException.getMessage());
            } // try
        } // for
    } // saveAll
} // Driver
