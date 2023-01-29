package cs1302.hw03.contract;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * An object that can be saved to a file. Implementing classes must have a
 * concrete definition for the {@link #save(java.io.File) save(File)} method,
 * and they should include a description of the file format (i.e., what
 * the contents of the saved file looks like) in their Javadoc comment.
 * Use of {@code @inheritDoc} is encouraged.
 */
public interface Savable {

    /**
     * Save the calling object to the specified {@code file}.
     *
     * @param file the file to save to
     * @throws FileNotFoundException when the specified file does not exist
     */
    void save(File file) throws FileNotFoundException;

} // Savable
