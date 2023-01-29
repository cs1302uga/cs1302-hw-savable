/**
 * Defines actions for classes that can be saved to a file. An implementing class
 * must have a concrete definition for the {@code save} method.
 */
public interface Savable {
    /**
     * Save the calling object to the specified {@code file}.
     *
     * @param file the file to save to.
     * @throws FileNotFoundException if the specified file doesn't exist.
     */
    void save(File file) throws FileNotFoundException;
} // Savable
