package algorithm;

public class Gamma {
    private double[][] alfaMatrix;
    private double[][] betaMatrix;
    private double[][] gammaMatrix;
    private int lengthOfObservation;
    private int numberOfState;
    private double probabilityOfObservation;

    public Gamma(double[][] alfaMatrix, double[][] betaMatrix, double probabilityOfObservation){
        this.alfaMatrix = alfaMatrix;
        this.betaMatrix = betaMatrix;
        this.lengthOfObservation = alfaMatrix.length;
        this.numberOfState = alfaMatrix[0].length;
        this.probabilityOfObservation = probabilityOfObservation;
    }

    public double[][] countGamma(){
        gammaMatrix = new double[lengthOfObservation][numberOfState];
        for(int t=0; t<lengthOfObservation; t++){
            for(int i=0; i<numberOfState; i++){
                gammaMatrix[t][i]=alfaMatrix[t][i]*betaMatrix[t][i]/probabilityOfObservation;
            }
        }
        return gammaMatrix;
    }
}
