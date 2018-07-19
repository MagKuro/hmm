package algorithm;

public class BetaPassAlgorithm {
    private double[][] aMatrix;
    private double[][] bMatrix;
    private double[] piMatrix;
    private int[] observations;
    private double[][] betaMatrix;
    private int lengthOfObservation;
    private int numberOfStates ;

    public BetaPassAlgorithm(double[][] aMatrix, double[][] bMatrix, double[] piMatrix, int[] observations){
        this.aMatrix = aMatrix;
        this.bMatrix = bMatrix;
        this.piMatrix = piMatrix;
        this.observations = observations;
        this.lengthOfObservation = observations.length;
        this.numberOfStates = aMatrix.length;
    }

    public double[][] doBetaPassAlgorithm(){
        betaMatrix = new double[lengthOfObservation][numberOfStates];
        for(int i=0; i<numberOfStates; i++){
            betaMatrix[lengthOfObservation-1][i]=1;
        }
        for(int t=lengthOfObservation-2; t>=0; t--){
            for(int i=0; i<numberOfStates; i++){
                for(int j=0; j<numberOfStates; j++){
                    betaMatrix[t][i]=betaMatrix[t][i]+(aMatrix[i][j]*bMatrix[j][observations[t+1]]*betaMatrix[t+1][j]);
                }
            }
        }
        return betaMatrix;
    }
}
