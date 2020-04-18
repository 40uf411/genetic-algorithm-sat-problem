package Models;

import Genetic.GA;

import java.util.Random;

public class Individual {

    public int fitness = 0;
    public int[] genes = new int[GA.pram[0]];
    public int geneLength = GA.pram[0];

    public Individual() {
        Random rn = new Random();
        int[] val = {1, -1};
        //Set genes randomly for each individual
        for (int i = 0; i < genes.length; i++) {
            genes[i] = Math.abs(rn.nextInt() % 10)>5? 1 : -1;
        }
        calcFitness();
    }
    public Individual(int[] g) {
        copy(g);
        calcFitness();
    }

    //Calculate fitness
    public void calcFitness() {
        fitness = GA.validate(genes);
    }

    public void copy(Individual i ){
        for (int j = 0; j < geneLength; j++) {
            this.genes[j] = i.genes[j];
        }
        calcFitness();
    }
    public void copy(int[] i ){
        for (int j = 0; j < geneLength; j++) {
            this.genes[j] = i[j];
        }
        calcFitness();
    }
    public boolean isSame(Individual i) {
        for (int j = 0; j < geneLength; j++) {
            if (genes[j] == i.genes[j])
                return true;
        }
        return false;
    }
}