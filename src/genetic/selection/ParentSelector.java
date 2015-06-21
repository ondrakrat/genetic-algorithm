package genetic.selection;

import genetic.Individual;
import genetic.Population;

/**
 * Interface for different methods of selecting {@link Individual}s from given {@link Population}, that will be chosen
 * as parents and crossed over afterwards.
 *
 * @author Ondřej Kratochvíl
 */
public interface ParentSelector {

    /**
     * Selects the individual that will be selected for crossover
     *
     * @param population
     * @return
     */
    Individual selectIndividual(Population population);
}
