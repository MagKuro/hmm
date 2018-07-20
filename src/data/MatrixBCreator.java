package data;

public class MatrixBCreator extends MatrixCreator {

    private double[][] matrixB = new double[numberOfStates][numberOfObservations];
    private double[][] finalMatrixB = new double[numberOfStates][numberOfObservations];
    private double[] sumVerse = new double[numberOfStates];

    public double[][] createMatrix(int[] states, int[]observations){
        for(int i=0; i<states.length; i++){
                matrixB[states[i]][observations[i]]++;
        }
        for(int s=0; s<numberOfStates; s++){
            for(int o=0; o<numberOfObservations; o++){
                sumVerse[s]=sumVerse[s]+matrixB[s][o];
            }
        }

        for(int s=0; s<numberOfStates; s++){
            for(int o=0; o<numberOfObservations; o++){
                finalMatrixB[s][o]=matrixB[s][o]/sumVerse[s];
            }
        }
        return finalMatrixB;
    }

    @Override
    public void showMatrix(double[][] matrix) {
        System.out.println("Macierz B:");
        super.showMatrix(matrix);
    }
}
