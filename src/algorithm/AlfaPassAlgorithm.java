package algorithm;

public class AlfaPassAlgorithm {
    private double[][] aMatrix;
    private double[][] bMatrix;
    private double[] piMatrix;
    private int[] observations;
    private double[][] alfaMatrix;
    private int lengthOfObservation;
    private int numberOfStates;


    public AlfaPassAlgorithm(double[][] aMatrix, double[][] bMatrix, double[] piMatrix, int[] observations){
        this.aMatrix = aMatrix;
        this.bMatrix = bMatrix;
        this.piMatrix = piMatrix;
        this.observations = observations;
        this.lengthOfObservation = observations.length;
        this.numberOfStates = aMatrix.length;
    }

    public double[][] doAlfaPassAlgorithm(){
        alfaMatrix = new double[lengthOfObservation][numberOfStates];
//        double[] scale = new double[lengthOfObservation];
        for(int i=0; i<numberOfStates; i++){
            alfaMatrix[0][i]=piMatrix[i]*bMatrix[i][observations[0]];
//            scale[0] = scale[0]+alfaMatrix[0][i];
        }
//        scale[0]=1.0/scale[0];
//        for(int i=0; i<numberOfStates; i++){
//            alfaMatrix[0][i]=scale[0]*alfaMatrix[0][i];
//        }
        for(int t=1; t<lengthOfObservation; t++){
            for(int i=0; i<numberOfStates; i++){
                for(int j=0; j<numberOfStates; j++){
                    alfaMatrix[t][i]=alfaMatrix[t][i]+(alfaMatrix[t-1][j]*aMatrix[j][i]);
                }
                alfaMatrix[t][i]=alfaMatrix[t][i]*bMatrix[i][observations[t]];
//                scale[t]=scale[t]+alfaMatrix[t][i];
            }
//            scale[t]=1.0/scale[t];
//            for(int i =0; i<numberOfStates;i++){
//                alfaMatrix[t][i]=scale[t]*alfaMatrix[t][i];
//            }
        }
        return alfaMatrix;
    }

    public double getElementFromAlfa(int t, int i){
        return alfaMatrix[t][i];
    }

    public double calculateOfProbabilityOfSequenceObservations(double[][] alfaMatrix){
        double probabilityOfSequenceObservations=0;
        for(int i=0; i<numberOfStates; i++){
            probabilityOfSequenceObservations=probabilityOfSequenceObservations+alfaMatrix[lengthOfObservation-1][i];
        }
        return probabilityOfSequenceObservations;
    }
}
