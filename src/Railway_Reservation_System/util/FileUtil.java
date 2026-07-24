package Railway_Reservation_System.util;

import java.io.*;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.ArrayList;
import java.util.Scanner;

import Railway_Reservation_System.model.User;
import Railway_Reservation_System.model.Passenger;
import Railway_Reservation_System.model.Train;

public class FileUtil {
   public static File myFile = new File("Initial_Java_Projects/src/Railway_Reservation_System/data/userData.txt");
   public static  File myfile2 = new File("Initial_Java_Projects/src/Railway_Reservation_System/data/Bookings.txt");

    public static void createFile() {

        try {
            myFile.createNewFile();

            System.out.println("File Created");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void saveUser(User user){
        try {
            FileWriter fw = new FileWriter("Initial_Java_Projects/src/Railway_Reservation_System/data/userData.txt",true);
            fw.write(user.getUserName().trim().toLowerCase() + "," +user.getPassword().trim()+","+user.getEmail()+","+user.getGender().trim()+","+user.getAge()+"\n");
            fw.close();

        }catch (IOException e){
            System.out.println(e);
        }


    }
    public static ArrayList<User> getAllUser() {
        ArrayList<User> users = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(myFile));){

            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length>=4){
                    String name=data[0].trim();
                    String password = data[1];
                    String email = data[2];
                    String gender =data[3];
                    int age = Integer.parseInt(data[4]);
                    users.add( new User(name,password,email,gender,age));
                }
            }
        } catch (Exception e){
            System.out.println(e);
        }
        return users;

    }

//    Bookings
    public static void bookingData(Passenger pass,Train train){

        try{
//            myfile.createNewFile();
            FileWriter fw = new FileWriter(myfile2,true);
            fw.write(pass.getPassengerName()+","+pass.getPassengerGender()+","+pass.getPassengerAge()+","+pass.getPnr()
                    +","+train.getSource()+","+train.getDestination()+","+train.getTrainName()+","+train.getTrainNo()+"\n");
            fw.close();
        }catch (Exception e){

            System.out.println(e);
        }
    }

    public static ArrayList<Passenger> getBookedPassenger(){
        ArrayList<Passenger> pass = new ArrayList<>();

        try( BufferedReader br = new BufferedReader( new FileReader(myfile2))){

            String line;
            while ((line= br.readLine())!=null){
                String [] data = line.split(",");
                String pnr = String.valueOf(data[3]);
                String name=data[0].trim();
                String age = data[2];
                String gender=data[1].trim();

                 pass.add(new Passenger(name,gender,Integer.parseInt(age),Integer.parseInt(pnr)));


            }
        }catch (Exception e){
            System.out.println(e);
        }
        return pass;
    }
    public static ArrayList<Train> getBookedTrain(){

        ArrayList<Train> train = new ArrayList<>();
        try(BufferedReader br = new BufferedReader( new FileReader(myfile2))){

            String line;
            while ((line= br.readLine())!=null){
                String [] data = line.split(",");

                String source = data[4].trim();
                String destination = data[5].trim();
                String trainName=data[6].trim();

                train.add(new Train(source,destination,0,trainName));

            }
        }catch (Exception e){
            System.out.println(e);
        }
        return train;
    }
    public static boolean changingFile(long pnr){
        File duplicateFile = new File("Initial_Java_Projects/src/Railway_Reservation_System/data/duplicateFile.txt");
        try(Scanner scv = new Scanner(myfile2)){

            FileWriter fw = new FileWriter(duplicateFile);


            while(scv.hasNextLine()){
                String line= scv.nextLine();
                String[] data=line.split(",");
                if (data[3].equals(String.valueOf(pnr))){
                    continue;
                }else {
                    fw.write(line+"\n");
                }

            }

            fw.close();
        }catch (IOException e){
            System.out.println(e);
        }
            if (myfile2.delete()){
                if (duplicateFile.renameTo(myfile2)){
//                    System.out.println("Booking deleted Successfully...");
                    return true;
                }else {
                    System.out.println("Failed to Rename");
                }
            }else {
                System.out.println("Failed to Delete OG file");
            }


        return false;

    }







}