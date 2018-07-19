package test;

public class ResultsComparator {
    int[] trueResult;
    int[] calculatedResult;
    int length;

    public ResultsComparator(int[] trueResult, String calculatedResult){
        this.trueResult = trueResult;
        this.length = trueResult.length;
        this.calculatedResult = new int[length];
        for(int t=0; t<this.length; t++){
            this.calculatedResult[t]=Integer.parseInt(String.valueOf(calculatedResult.charAt(t)));
        }
    }

    public double compare(){
        int same=0;

        for (int t=0; t<length; t++){
            if(trueResult[t]==calculatedResult[t]){
                same++;
            }
        }
        return same*100.0/length;
    }
}
