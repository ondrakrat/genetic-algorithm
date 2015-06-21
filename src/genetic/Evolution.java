package genetic;

import genetic.selection.ParentSelector;

import java.util.Random;

/**
 * Represents the evolution algorithm itself, contains methods performing crossover and mutation
 *
 * @author Ondřej Kratochvíl
 */
public class Evolution {

    private final double MUTATION_CHANCE = 0.01;    // the chance of every gene to be randomly mutated
    private final boolean ELITISM = true;  // whether to carry the fittest individual to the next generation
    private ParentSelector parentSelector;  // algorithm for selecting parents from a population

    public Evolution(ParentSelector parentSelector) {
        this.parentSelector = parentSelector;
    }

    /**
     * Combines the genes of given individuals and returns a new one. Genes have a chance of mutation.
     *
     * @param i1
     * @param i2
     * @return new {@link Individual} combined from given parents
     */
    public Individual crossover(Individual i1, Individual i2) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(Fitness.SOLUTION.length());
        for (int i = 0; i < Fitness.SOLUTION.length(); ++i) {
            if (random.nextDouble() <= MUTATION_CHANCE) {
                sb.append(mutate());
            } else {
                // toDo: change the method of choosing genes
                sb.append(random.nextDouble() < 0.5 ? i1.getValue().charAt(i) : i2.getValue().charAt(i));
            }
        }
        return new Individual(sb.toString());
    }

    /**
     * Combines the fittest {@link Individual}s from the given {@link Population} and creates a new one
     *
     * @param oldPopulation
     * @return new {@link Population}
     */
    public Population evolvePopulation(Population oldPopulation) {
        Population newPopulation = new Population(false);
        ++Population.GENERATION;
        if (ELITISM) {
            newPopulation.getMembers()[0] = oldPopulation.getFittest();
        }
        for (int i = ELITISM ? 1 : 0; i < Population.POPULATION_SIZE; ++i) {
            newPopulation.getMembers()[i] = crossover(parentSelector.selectIndividual(oldPopulation),
                    parentSelector.selectIndividual(oldPopulation));
        }
        return newPopulation;
    }

    /**
     * Mutates a single gene (= returns a random letter)
     *
     * @return
     */
    private char mutate() {
        System.out.println("Mutating gene");
        return (char) (new Random().nextInt(26) + 'a');
    }
}
