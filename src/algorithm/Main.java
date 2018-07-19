package algorithm;

import data.DataCreator;
import data.MatrixACreator;
import data.MatrixBCreator;
import data.MatrixPiCreater;
import test.ResultsComparator;

public class Main {
    public static void main(String[] args) {
        DataCreator dataCreator = new DataCreator();
        dataCreator.readFromFile("dataTrening.csv");

        DataCreator awaitedResultsCreator = new DataCreator();
        awaitedResultsCreator.readFromFile("dataTest.csv");

        MatrixACreator matrixACreator = new MatrixACreator();
        double[][] matrixA = matrixACreator.createMatrix(dataCreator.getCancellationMatrix());
        matrixACreator.showMatrix(matrixA);

        MatrixBCreator matrixBCreator = new MatrixBCreator();
        double[][] matrixB = matrixBCreator.createMatrix(dataCreator.getCancellationMatrix(), dataCreator.getSnowfallMatrix());
        matrixBCreator.showMatrix(matrixB);

        MatrixPiCreater matrixPiCreater = new MatrixPiCreater();
        double[] matrixPi = matrixPiCreater.createMatrixPi(dataCreator.getCancellationMatrix());
        matrixPiCreater.showMatrix(matrixPi);

        int[] sequenceObservation = awaitedResultsCreator.getSnowfallMatrix();
        AlfaPassAlgorithm alfaPassAlgorithm = new AlfaPassAlgorithm(matrixA, matrixB, matrixPi, sequenceObservation);
        double[][] alfaMatrix = alfaPassAlgorithm.doAlfaPassAlgorithm();
        double probabilityOfObservation = alfaPassAlgorithm.calculateOfProbabilityOfSequenceObservations(alfaMatrix);
        BetaPassAlgorithm betaPassAlgorithm = new BetaPassAlgorithm(matrixA, matrixB, matrixPi, sequenceObservation);
        double[][] betaMatrix = betaPassAlgorithm.doBetaPassAlgorithm();
        Gamma gamma = new Gamma(alfaMatrix, betaMatrix, probabilityOfObservation);
        gamma.countGamma();
        String hmmSequence = gamma.findTheMostProbabilityStates();
        System.out.println("Sekwencja najbardzej prawdopodobnych stanów to: "+hmmSequence);

        DynamicProgramming dynamicProgramming = new DynamicProgramming(matrixA, matrixB, matrixPi, sequenceObservation);
        String dpSequence = dynamicProgramming.doDynamicProgramming();
        System.out.println("Najbardziej prawdopodobna sekwencja stanów to: "+dpSequence);

        ResultsComparator hmmComparator = new ResultsComparator(awaitedResultsCreator.getCancellationMatrix(), hmmSequence);
        System.out.println("Zgodność dla HMM algorithm wynosi: "+ hmmComparator.compare());

        ResultsComparator dpComparator = new ResultsComparator(awaitedResultsCreator.getCancellationMatrix(), dpSequence);
        System.out.println("Zgodność dla DP algorithm wynosi: "+ dpComparator.compare());
    }
}
