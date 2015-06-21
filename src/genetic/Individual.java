package genetic;

import java.util.Random;

/**
 * Represents one particular element of a {@link Population}
 *
 * @author Ondřej Kratochvíl
 */
public class Individual {

    private final String value;

    /**
     * Initializes this {@link Individual}'s value to a random string of lower case letter of given length
     *
     * @param size the length of the string
     */
    public Individual(int size) {
        StringBuilder sb = new StringBuilder(size);
        for (int i = 0; i < size; ++i) {
            Random random = new Random();
            sb.append((char)(random.nextInt(26) + 'a'));
        }
        value = sb.toString();
    }

    /**
     * Initializes this {@link Individual}'s value to given string
     *
     * @param value
     */
    public Individual(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
