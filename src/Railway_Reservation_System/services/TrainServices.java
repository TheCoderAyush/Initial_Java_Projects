package Railway_Reservation_System.services;
import Railway_Reservation_System.model.Train;
import Railway_Reservation_System.util.FileUtil;
import Railway_Reservation_System.util.Input;
import Railway_Reservation_System.util.TrainFile;
import Railway_Reservation_System.util.PnrGeneration;


import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;

public class TrainServices {
    public static void trainData(){


        TrainFile.trainRecord( new Train("Prayagraj","Ballia",18310,"Rajdhani Express"));
        TrainFile.trainRecord(new Train("Ballia","Prayagraj",18210,"Prayagraj Express"));
        TrainFile.trainRecord(new Train("Delhi","Ballia",18910,"Ballia Express"));
        TrainFile.trainRecord(new Train("Jhusi","Rambag",186710,"Memu Express"));
        TrainFile.trainRecord(new Train("Ramnathpur","Banaras",18410,"Vibhuti Express"));
        TrainFile.trainRecord(new Train("Pratapgarh","Prayagraj",18110,"Rampur Express"));
        TrainFile.trainRecord(new Train("Prayagraj","Jammu",18510,"Kamini Express"));
        TrainFile.trainRecord(new Train("Prayagraj","Mumbai",187810,"Vande Express"));
        TrainFile.trainRecord(new Train("Gyanpur","Ballia",185510,"Rampur Express"));
        TrainFile.trainRecord(new Train("Prayagraj","Ballia",186710,"Bharat Express"));
        TrainFile.trainRecord(new Train("Sonbhadra","Banaras",184410,"Vande Bharat Express"));
    }



    public static void displayAllTrain(){
        for(Train trainDetail : TrainFile.readTrainRecord() ){
            System.out.println("Name : "+trainDetail.getTrainName() +","+ "Source : "+trainDetail.getSource()+","+"Destination : "+
                    trainDetail.getDestination()+","+"Train N0. :"+trainDetail.getTrainNo());
        }

    }
    public static Train searchTrain() {
        ArrayList<String> trianName = new ArrayList<>();

        System.out.println("Enter Source : ");
        String source = Input.sc.nextLine();
        System.out.println("Enter Destination : ");
        String des = Input.sc.nextLine();
        for (Train search : TrainFile.readTrainRecord()) {
            if (source.equalsIgnoreCase(search.getSource()) && (des.equalsIgnoreCase(search.getDestination()))) {
                trianName.add(search.getTrainName());

            }
        }
        System.out.println("Available Trains are : "+trianName);
        System.out.println("Enter train name to Select : ");
        String tname= Input.sc.nextLine();
        for (String name : trianName){
            if (tname.equalsIgnoreCase(name)){
                Train t = new Train(source,des,0, tname);
                return t;
            }
        }
        Train t2 = new Train(source,des,1,tname);
        return t2;
    }



}
