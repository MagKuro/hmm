package algorithm;

public class DynamicProgramming {
    private double[][] aMatrix;
    private double[][] bMatrix;
    private double[] piMatrix;
    private int[] observations;
    private double[][] deltaMatrix;
    private int lengthOfObservation;
    private int numberOfStates ;
    private double probabilityOfSequenceStates;
    private String sequenceOfStates;

    public DynamicProgramming(double[][] aMatrix, double[][] bMatrix, double[] piMatrix, int[] observations){
        this.aMatrix = aMatrix;
        this.bMatrix = bMatrix;
        this.piMatrix = piMatrix;
        this.observations = observations;
        this.lengthOfObservation = observations.length;
        this.numberOfStates = aMatrix.length;
    }

    public String doDynamicProgramming(){
        deltaMatrix = new double[lengthOfObservation][numberOfStates];
        String[] previousSequence = new String[numberOfStates];
        String[] sequence = new String[numberOfStates];

        for(int i = 0; i<numberOfStates; i++){
            deltaMatrix[0][i] = piMatrix[i]*bMatrix[i][observations[0]];
            previousSequence[i] = String.valueOf(i);
        }

        for(int t=1; t<lengthOfObservation; t++){
            for(int i = 0; i<numberOfStates; i++){
                double max=0;
                for(int j = 0; j<numberOfStates; j++){
                    double actualDelta = deltaMatrix[t-1][j]*aMatrix[j][i]*bMatrix[i][observations[t]];
                    if(max<actualDelta){
                        max = actualDelta;
                        deltaMatrix[t][i]=actualDelta;
                        sequence[i] = previousSequence[j]+i;
                    }
                }
            }
            for(int i2=0; i2<numberOfStates; i2++){
                previousSequence[i2]=sequence[i2];
            }
        }

        for(int j=0; j<numberOfStates; j++){
            if(probabilityOfSequenceStates<deltaMatrix[lengthOfObservation-1][j]){
                probabilityOfSequenceStates=deltaMatrix[lengthOfObservation-1][j];
                sequenceOfStates = sequence[j];
            }
        }
        return sequenceOfStates;
    }

    public String getSequenceOfStates() {
        return sequenceOfStates;
    }

    public double getProbabilityOfSequenceStates() {
        return probabilityOfSequenceStates;
    }
}
