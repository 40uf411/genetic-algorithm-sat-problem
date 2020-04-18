package sample;

import Genetic.GA;

public class Runner {
    public static void main(String[] args) {
        Thread gene  = new Thread(new GA());
        Thread graph = new Thread(new Graph());
        graph.start();
        gene.start();
    }
}
