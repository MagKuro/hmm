package data;

public class MatrixACreator extends MatrixCreator{

    private double[][] matrixA = new double[numberOfStates][numberOfStates];
    private double[][] finalMatrixA = new double[numberOfStates][numberOfStates];

    public double[][] createMatrix(int[] states){
        int oldState = 0;

        for(int s=0; s<states.length; s++){
            if(s!=0){
                matrixA[oldState][states[s]]++;
            }
            oldState = states[s];
        }

        finalMatrixA[0][0] = matrixA[0][0]/(matrixA[0][0]+matrixA[0][1]);
        finalMatrixA[0][1] = matrixA[0][1]/(matrixA[0][0]+matrixA[0][1]);
        finalMatrixA[1][0] = matrixA[1][0]/(matrixA[1][0]+matrixA[1][1]);
        finalMatrixA[1][1] = matrixA[1][1]/(matrixA[1][0]+matrixA[1][1]);

        return finalMatrixA;
    }

    @Override
    public void showMatrix(double[][] matrix) {
        System.out.println("Macierz A:");
        super.showMatrix(matrix);
    }
}
