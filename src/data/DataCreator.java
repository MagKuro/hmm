package data;

import java.io.*;

public class DataCreator {
    private int treningNumber = 800;
    private int testNumber = 1095-treningNumber;
    private int[] temperatureAndHumidityMatrix;
    private int[] pressureMatrix;
    private int numberOfLine = 0;

    public int readFromFile(String fileName){
        try {

            if(fileName.equals("trening.csv")){
                temperatureAndHumidityMatrix = new int[treningNumber];
                pressureMatrix = new int[treningNumber];
            }
            else{
                temperatureAndHumidityMatrix = new int[testNumber];
                pressureMatrix = new int[testNumber];
            }
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String currentLine;

            double temperature;
            double pressure;
            double humidity;

            while ((currentLine = br.readLine()) != null) {
                String[] currentTab = currentLine.split(",");
                pressure = Double.parseDouble(currentTab[0]);
                temperature = Double.parseDouble(currentTab[1]);
                humidity = Double.parseDouble(currentTab[2]);

                //pressure
                //0 - maleje
                if(pressure>0){ //dodatnia
                    pressureMatrix[numberOfLine]=0;
                }
                //1 - rośnie
                else{
                    pressureMatrix[numberOfLine]=1;
                }

                //temperature and humidity
                //0 - maleje temperatura i maleje wilgotnosc
                //1 - maleje temperatura i rosnie wilgotnosc
                //2 - rosnie temperatura i maleje wilgotnosc
                //3 - rosnie temperatura i rosnie wilgotnosc
                if(temperature>0){
                    if(humidity>0){
                        temperatureAndHumidityMatrix[numberOfLine]=0;
                    }
                    else{
                        temperatureAndHumidityMatrix[numberOfLine]=1;
                    }
                }
                else{
                    if(humidity>0){
                        temperatureAndHumidityMatrix[numberOfLine]=2;
                    }
                    else{
                        temperatureAndHumidityMatrix[numberOfLine]=3;
                    }
                }
                numberOfLine++;
            }
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return numberOfLine;
    }

    public int[] getPressureMatrix() {
        return pressureMatrix;
    }

    public int[] getTemperatureAndHumidityMatrix() {
        return temperatureAndHumidityMatrix;
    }
}
