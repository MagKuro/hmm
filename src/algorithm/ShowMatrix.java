package algorithm;

public class ShowMatrix {
    double[][] matrix;
    public ShowMatrix(double[][] matrix) {
        this.matrix = matrix;
    }
    public void show(){
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
