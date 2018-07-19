package algorithm;

public class MatrixCreator {
    protected final int numberOfStates = 2;
    protected final int numberOfObservations = 3;

    public void showMatrix(double[][] matrix){
        String line;
        for(int v=0; v<matrix.length; v++){
            line="";
            for(int c=0; c<matrix[0].length; c++){
                line=line+" "+matrix[v][c];
            }
            System.out.println(line);
        }
    }
}
