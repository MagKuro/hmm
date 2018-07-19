package Test;

import algorithm.*;

public class Main {
    public static void main(String[] args) {
        double[][] matrixA = {{0.7, 0.3},{0.4, 0.6}};
        double[][] matrixB = {{0.1,0.4,0.5},{0.7,0.2,0.1}};
        double[] matrixPi = {0.6, 0.4};

        int[] sequenceObservation = {0,1,0,2}; //wynik 0,009629 - nieskalowane
        AlfaPassAlgorithm alfaPassAlgorithm = new AlfaPassAlgorithm(matrixA, matrixB, matrixPi, sequenceObservation);
        double[][] alfaMatrix = alfaPassAlgorithm.doAlfaPassAlgorithm();
        //System.out.println("Wystapienie sekwencji obserwacji wynosi: "+alfaPassAlgorithm.calculateOfProbabilityOfSequenceObservations(alfaMatrix));
        double probabilityOfObservation = alfaPassAlgorithm.calculateOfProbabilityOfSequenceObservations(alfaMatrix);
        BetaPassAlgorithm betaPassAlgorithm = new BetaPassAlgorithm(matrixA, matrixB, matrixPi, sequenceObservation);
        double[][] betaMatrix = betaPassAlgorithm.doBetaPassAlgorithm();
        Gamma gamma = new Gamma(alfaMatrix, betaMatrix, probabilityOfObservation);
        gamma.countGamma();
        System.out.println("Sekwencja najbardzej prawdopodobnych stanów to: "+gamma.findTheMostProbabilityStates());

        DynamicProgramming dynamicProgramming = new DynamicProgramming(matrixA, matrixB, matrixPi, sequenceObservation);
        System.out.println("Najbardziej prawdopodobna sekwencja stanów to: "+dynamicProgramming.doDynamicProgramming());

    }
}
