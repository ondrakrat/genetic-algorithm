package genetic;

/**
 * Represents one generation of {@link Individual}s
 *
 * @author Ondřej Kratochvíl
 */
public class Population {

    public static final int POPULATION_SIZE = 20;
    public static int GENERATION = 1;
    private Individual[] members;
    private int totalFitness = -1;

    /**
     * Create initial population
     */
    public Population(boolean initialize) {
        members = new Individual[POPULATION_SIZE];
        if (initialize) {
            for (int i = 0; i < POPULATION_SIZE; ++i) {
                members[i] = new Individual(Fitness.SOLUTION.length());
            }
        }
    }

    public Individual[] getMembers() {
        return members;
    }

    /**
     * Returns an {@link Individual} at given position, or return null if argument is greater than population size
     *
     * @param i
     * @return
     */
    public Individual getMember(int i) {
        return i < POPULATION_SIZE ? members[i] : null;
    }

    /**
     * Returns the fittest {@link Individual} in this {@link Population}
     *
     * @return
     */
    public Individual getFittest() {
        int highestFitness = 0;
        int fittestPos = 0;
        for (int i = 0; i < POPULATION_SIZE; ++i) {
            int fitnessValue = Fitness.calculateFitness(getMember(i));
            if (fitnessValue > highestFitness) {
                highestFitness = fitnessValue;
                fittestPos = i;
            }
        }
        return getMember(fittestPos);
    }

    /**
     * Sums the fitness of all {@link Individual}s in the {@link Population}
     */
    private void calculateTotalFitness() {
        totalFitness = 0;
        for (Individual member : members) {
            totalFitness += Fitness.calculateFitness(member);
        }
    }

    public int getTotalFitness() {
        if (totalFitness == -1) {
            calculateTotalFitness();
        }
        return totalFitness;
    }
}
