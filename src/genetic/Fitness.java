package genetic;

/**
 * Contains the solution and calculates fitness of {@link Individual}s
 *
 * @author Ondřej Kratochvíl
 */
public class Fitness {

    public static String SOLUTION;
    public static int MAX_FITNESS;

    /**
     * Creates an instance with given solution (that is converted to lower case and all non-characters are omitted)
     *
     * @param solution
     */
    public Fitness(String solution) {
        if (!solution.matches("[a-zA-Z]+")) {
            SOLUTION = solution.replaceAll("[^a-zA-Z]", "").toLowerCase();
        } else {
            SOLUTION = solution.toLowerCase();
        }
        MAX_FITNESS = 26 * SOLUTION.length();
    }

    /**
     * Calculates fitness value of given individual.
     *
     * @param individual
     * @return fitness value
     */
    public static int calculateFitness(Individual individual) {
        int fitness = 0;
        for (int i = 0; i < SOLUTION.length(); ++i) {
            fitness += 26 - Math.abs(SOLUTION.charAt(i) - individual.getValue().charAt(i));
        }
        return fitness;
    }
}
