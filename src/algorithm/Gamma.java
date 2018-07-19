package algorithm;

public class Gamma {
    private double[][] alfaMatrix;
    private double[][] betaMatrix;
    private double[][] gammaMatrix;
    private int lengthOfObservation;
    private int numberOfState;
    private double probabilityOfObservation;
    private String theMostProbabilityStates;
    private double probabilityOfTheMostProbabilityStates;

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

    public String findTheMostProbabilityStates(){
        double probability =0;
        String sequence="";
        double max;
        int indexMax;

        for(int t=0; t<lengthOfObservation; t++){
            max=0;
            indexMax=-1;
            for(int i=0; i<numberOfState; i++){
                if(max<gammaMatrix[t][i]){
                    max = gammaMatrix[t][i];
                    indexMax = i;
                }
            }
            sequence = sequence+indexMax;
            probability = probability + max/lengthOfObservation;
        }
        theMostProbabilityStates = sequence;
        probabilityOfTheMostProbabilityStates = probability;

        return theMostProbabilityStates;
    }

    public double getProbabilityOfTheMostProbabilityStates() {
        return probabilityOfTheMostProbabilityStates;
    }
}
