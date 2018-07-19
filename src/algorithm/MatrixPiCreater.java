package algorithm;

public class MatrixPiCreater extends MatrixCreator{
    double[] pi = new double[numberOfStates];

    public double[] createMatrixPi(int[] states){
        int sum=0;
        for(int s=0; s<states.length; s++){
            pi[states[s]]++;
            sum++;
        }
        for(int n=0; n<numberOfStates; n++){
            pi[n]=pi[n]/sum;
        }
        return pi;
    }

    public void showMatrix(double[] matrix){
        System.out.println("Macierz pi:");
        String line = "";
        for(int v=0; v<matrix.length; v++){
                line=line+" "+matrix[v];
        }
        System.out.println(line);
    }


}
