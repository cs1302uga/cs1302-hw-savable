package cs1302.hw.impl;

/**
 * Represents a textbook used for a class. Each object stores the book's title
 * and publisher.
 */
public class TextBook {
    private String title;
    private String publisher;

    /**
     * Creates a new {@code TextBook} object with the specified title and publisher
     * values.
     *
     * @param title the book's title.
     * @param publisher the book's publisher.
     */
    public TextBook(String title, String publisher) {
        setTitle(title);
        setPublisher(publisher);
    } // TextBook

    /**
     * Returns the book's title.
     *
     * @return the book's title.
     */
    public String getTitle() {
        return this.title;
    } // getTitle

    /**
     * Returns the book's publisher.
     *
     * @return the book's publisher.
     */
    public String getPublisher() {
        return this.publisher;
    } // getPublisher

    /**
     * Sets the book's title to the specified {@code title} value.
     *
     * @param title the updated book title.
     */
    public void setTitle(String title) {
        this.title = title;
    } // setTitle

    /**
     * Sets the book's publisher to the specified {@code publisher} value.
     *
     * @param publisher the updated book publisher.
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    } // set Publisher

} // TextBook
