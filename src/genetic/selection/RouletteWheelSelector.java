package genetic.selection;

import genetic.Fitness;
import genetic.Individual;
import genetic.Population;

import java.util.Random;

/**
 * @author Ondřej Kratochvíl
 */
public class RouletteWheelSelector implements ParentSelector {

    @Override
    public Individual selectIndividual(Population population) {
        int random = new Random().nextInt(population.getTotalFitness());
        int sum = 0;
        for (Individual individual : population.getMembers()) {
            sum += Fitness.calculateFitness(individual);
            if (sum > random) {
                return individual;
            }
        }
        throw new RuntimeException("No individual was chosen for crossover!");
    }
}
