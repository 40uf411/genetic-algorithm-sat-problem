package Models;

//Population class
public class Population {

    public int popSize = 10;

    public Individual[] individuals;
    public int fittest = 0;

    public void empPop(int size) {
        individuals = new Individual[size];
        popSize = size;
    }
    //Initialize population
    public void initializePopulation(int size) {
        individuals = new Individual[size];
        popSize = size;
        for (int i = 0; i < size; i++) {
            individuals[i] = new Individual();
        }
    }

    //Get the fittest individual
    public Individual getFittest() {
        int maxFit = Integer.MIN_VALUE;
        int maxFitIndex = 0;
        for (int i = 0; i < individuals.length; i++) {
            if (maxFit <= individuals[i].fitness) {
                maxFit = individuals[i].fitness;
                maxFitIndex = i;
            }
        }
        fittest = individuals[maxFitIndex].fitness;
        return individuals[maxFitIndex];
    }

    //Get the second most fittest individual
    public Individual getSecondFittest() {
        int maxFit1 = 0;
        int maxFit2 = 0;
        for (int i = 0; i < individuals.length; i++) {
            if (individuals[i].fitness > individuals[maxFit1].fitness) {
                maxFit2 = maxFit1;
                maxFit1 = i;
            } else if (individuals[i].fitness > individuals[maxFit2].fitness) {
                maxFit2 = i;
            }
        }
        return individuals[maxFit2];
    }

    //Get index of least fittest individual
    public int getLeastFittestIndex() {
        int minFitVal = Integer.MAX_VALUE;
        int minFitIndex = 0;
        for (int i = 0; i < individuals.length; i++) {
            if (minFitVal >= individuals[i].fitness) {
                minFitVal = individuals[i].fitness;
                minFitIndex = i;
            }
        }
        return minFitIndex;
    }

    //Calculate fitness of each individual
    public void calculateFitness() {
        getFittest();
    }

    public void print() {
        for (Individual ind : individuals) {
            System.out.print("f: " + ind.fitness + "\t|\t");
            for (int i = 0; i < ind.geneLength; i++) {
                System.out.print(ind.genes[i] + "\t ");
            }

            System.out.println("");
        }
    }
}