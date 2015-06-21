package genetic;

/**
 * Created by Ondřej Kratochvíl on 21.6.15.
 */
public class Main {

    public static void main(String[] args) {
        Fitness fitness = new Fitness("pokus");
        Evolution evolution = new Evolution();
        System.out.printf("Solution set to '%s', maximum fitness value is %d%n%n", Fitness.SOLUTION, Fitness.MAX_FITNESS);
        Population population = null;
        do {
            population = population == null ? new Population(true) : evolution.evolvePopulation(population);
            System.out.printf("*****Generation %d*****%n", Population.GENERATION);
            for (int i = 0; i < Population.POPULATION_SIZE; ++i) {
                Individual member = population.getMember(i);
                System.out.printf("Individual %2d: %s, fitness value: %d%n", i, member.getValue(), fitness.calculateFitness(member));
            }
            System.out.println("----------");
            System.out.printf("Highest fitness: %d%n", Fitness.calculateFitness(population.getFittest()));
        } while (Fitness.calculateFitness(population.getFittest()) < Fitness.MAX_FITNESS);
        System.out.printf("%nFound solution in generation %d%n", Population.GENERATION);
    }
}
