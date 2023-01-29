package cs1302.hw03.contract;

/**
 * Represents the progress made in a video game. Each object stores the user's current
 * score and level.
 */
public class GameProgress implements Savable {
    /** Represents the user's current score in the game.*/
    private int score;

    /** Represents the level the user is on in the game.*/
    private int level;

    /**
     * Creates a new {@code GameProgress} object with the specified score and level
     * values.
     *
     * @param score the user's current score in the game. This can be negative.
     * @param level the user's current level in the game.
     * @throws IllegalArgumentException when level is not positive.
     */
    public GameProgress(int score, int level) {
        setScore(score);
        setLevel(level);
    } // GameProgress

    /**
     * Returns the user's current score in the game.
     *
     * @return the user's current score.
     */
    public int getScore() {
        return this.score;
    } // getScore

    /**
     * Returns the user's current level in the game.
     *
     * @return the user's current level.
     */
    public int getLevel() {
        return this.level;
    } // getLevel

    /**
     * Sets the user's current score to the specified {@code score} value.
     * Negative score values are allowed.
     *
     * @param score the updated score value.
     */
    public void setScore(int score) {
        this.score = score;
    } // setScore

    /**
     * Sets the user's current level to the specified {@code level} value.
     * Negative level values are not allowed.
     *
     * @param level the updated level value.
     * @throws IllegalArgumentException if {@code level} is not positive.
     */
    public void setLevel(int level) {
        if (level > 0) {
            this.level = level;
        } else {
            IllegalArgumentException iae = new IllegalArgumentException("Level must be positive");
            throw iae;
        } // if
    } // setLevel

    /**
     * {@inheritDoc} Writes the instance variables of the class (one per line)
     * to the specified {@code file}. The first line contains the current score
     * of the game and the second line contains the current level.
     */
    @Override
    public void save(File file) throws FileNotFoundException {
        PrintWriter fileOut = new PrintWriter(file);
        fileOut.println(this.score);
        fileOut.println(this.level);
        fileOut.close();
    } // save
} // GameProgress
