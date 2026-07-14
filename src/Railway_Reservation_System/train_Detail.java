package Railway_Reservation_System;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class train_Detail {
  public static   void train(String trainName, String source, String destination, String trainNumber) {
        try {
            File myfile = new File("Initial_Java_Projects/src/Railway_Reservation_System/train.Data.txt");
            FileWriter fw = new FileWriter("Initial_Java_Projects/src/Railway_Reservation_System/train.Data.txt",true);
            fw.write(trainName+ "," + source + "," + destination + "," + trainNumber+"\n");
            fw.close();
//            myfile.delete();
            System.out.println("Done");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {

//        train("Rajdhani Express","Prayagraj","Ranchi Junction","18310");
//        train("Gorakhpur Express","Delhi","Varansi Junction","18789");
//        train("Swarna Express","Banaras","Prayagraj Junction","18908");
//        train("Jhatu Express","Prayagraj","Ranchi Junction","18785");
//        train("kamini Express","Bokaro Steel","Jaitpur Junction","19076");
//        train("Memu Express","Ramnathpur"," Rambhag","18890");
//        train("Deccan Bullet Express","Mumbai","Pune Junction","12105");
//        train("Desert Horizon Express","Howrah Junction","Chennai Central","12842");
//        train("Malabar Night Rider","Mangaluru Central","Jharkhand","16630");
//        train("Ganga Yamuna","Haridwar","Prayagraj","13010");
    }
    void displayTrain(){
        System.out.println("\t\t\t------------Available Train Routes----------\n");
        try {
            Scanner sc = new Scanner(new File("Initial_Java_Projects/src/Railway_Reservation_System/train.Data.txt"));
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String[] data=line.split(",");
                System.out.println("Train Name : "+data[0]+" , Source : "+data[1]+" , Destination : "+data[2]+" , Train N0. : "+data[3]+"\n");
            }
            sc.close();

        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

    }
}