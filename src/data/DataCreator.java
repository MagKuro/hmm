package data;

import java.io.*;

public class DataCreator {
    private final int numberOfDays = 366;
    private int[] snowfallMatrix = new int[numberOfDays];
    private int[] cancellationMatrix  = new int[numberOfDays];

    public void readFromFile(String fileName){
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String currentLine;
            int numberOfLine = 0;
            double snowfall;

            while ((currentLine = br.readLine()) != null) {
                String[] currentTab = currentLine.split(",");
                //wielkosc opadow śniegu
                if(currentTab[0].equals("T") ||currentTab[0].equals("M") ){
                    currentTab[0]= String.valueOf(0.0);
                }
                snowfall = Double.parseDouble(currentTab[0]);
                //0 - brak opadów
                if(snowfall==0){
                    snowfallMatrix[numberOfLine]=0;
                }
                //1 - średnie opady
                if(snowfall>0 && snowfall<3){
                    snowfallMatrix[numberOfLine]=1;
                }
                //2 - wysokie opady
                if(snowfall>=3){
                    snowfallMatrix[numberOfLine]=2;
                }
                //odwołane i odbyte loty
                if(currentTab.length>1){
                    //1 - lot odwołany
                    cancellationMatrix[numberOfLine] = 1;
                }
                else{
                    //0 - lot odbyty
                    cancellationMatrix[numberOfLine] = 0;
                }

                numberOfLine++;
            }
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int[] getCancellationMatrix() {
        return cancellationMatrix;
    }

    public int[] getSnowfallMatrix() {
        return snowfallMatrix;
    }
}
