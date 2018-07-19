package algorithm;

import data.DataCreator;

public class Main {
    public static void main(String[] args) {
        DataCreator dataCreator = new DataCreator();
        dataCreator.readFromFile();

        MatrixACreator matrixACreator = new MatrixACreator();
        double[][] matrixA = matrixACreator.createMatrix(dataCreator.getCancellationMatrix());
        matrixACreator.showMatrix(matrixA);

        MatrixBCreator matrixBCreator = new MatrixBCreator();
        double[][] matrixB = matrixBCreator.createMatrix(dataCreator.getCancellationMatrix(), dataCreator.getSnowfallMatrix());
        matrixBCreator.showMatrix(matrixB);

        MatrixPiCreater matrixPiCreater = new MatrixPiCreater();
        double[] matrixPi = matrixPiCreater.createMatrixPi(dataCreator.getCancellationMatrix());
        matrixPiCreater.showMatrix(matrixPi);

        AlfaPassAlgorithm alfaPassAlgorithm;
        double[][] alfa;
        for(int i=0; i<matrixB[0].length; i++){
            int[] sequenceObservation = {0, i};
            alfaPassAlgorithm = new AlfaPassAlgorithm(matrixA, matrixB, matrixPi, sequenceObservation);
            alfa = alfaPassAlgorithm.doAlfaPassAlgorithm();
            System.out.println("Wystapienie sekwencji obserwacji 0,"+i+" wynosi: "+alfaPassAlgorithm.calculateOfProbabilityOfSequenceObservations(alfa));

        }
    }
}
