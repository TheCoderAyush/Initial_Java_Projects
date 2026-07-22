package Railway_Reservation_System.util;
import  Railway_Reservation_System.model.Train;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;

public class TrainFile {
   public static File trainFile = new File("Initial_Java_Projects/src/Railway_Reservation_System/data/trainData.txt");
    public static void trainRecord(Train train){
        try{
            FileWriter fw = new FileWriter("Initial_Java_Projects/src/Railway_Reservation_System/data/trainData.txt",true);
            fw.write(train.getSource()+","+train.getDestination()+","+train.getTrainNo()+","+train.getTrainName()+"\n");
            fw.close();

            System.out.println("Written");
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static ArrayList<Train> readTrainRecord(){
        ArrayList<Train> trainRecord  = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(trainFile));
            String line;
            while((line=br.readLine())!=null){
                String[] data = line.split(",");
                String source=data[0].trim();
                String destination = data[1].trim();
                int trainNo1=Integer.parseInt(data[2]);
                String trainName=data[3].trim();

                trainRecord.add(new Train(source,destination,trainNo1,trainName));
            }
        }catch (FileNotFoundException e){
            System.out.println(e);
        }catch (Exception e){
            System.out.println(e);
        }

        return trainRecord;
    }


    }

