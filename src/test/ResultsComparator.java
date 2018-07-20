package test;

public class ResultsComparator {
    private int[] trueResult;
    private int[] calculatedResult;
    private int numberOfData;

    public ResultsComparator(int[] trueResult, String calculatedResult, int numberOfData){
        this.trueResult = trueResult;
        this.numberOfData = numberOfData;
        this.calculatedResult = new int[this.numberOfData];
        for(int t=0; t<this.numberOfData; t++){
            this.calculatedResult[t]=Integer.parseInt(String.valueOf(calculatedResult.charAt(t)));
        }

    }

    public double compare(){
        int same=0;

        for (int t=0; t<numberOfData; t++){
            if(trueResult[t]==calculatedResult[t]){
                same++;
            }
        }
        return same*100.0/numberOfData;
    }
}
