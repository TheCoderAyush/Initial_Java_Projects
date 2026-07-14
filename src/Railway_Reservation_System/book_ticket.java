package Railway_Reservation_System;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

class book_ticket extends Login{
     Scanner sc = new Scanner(System.in);
     Random rand = new Random();
     String passengerName;
     String trainName;
     String passengerAge;
     String passengerGender;
     int pnr;
     String source;
     String Destination;
     int trainN0;


     void passengersDetail() throws Exception{


          System.out.println("Enter  Your Name : ");
           String name=sc.nextLine();
           if(name.matches("[a-zA-Z ]+" )){

                passengerName=name;
           }else{
               throw new Exception("Invalid Name");

           }
          System.out.println("Enter Your Age : ");
           String  age= sc.next();
          if (age.matches("[0-9]+")){
               passengerAge=age;
          }else {
              throw new Exception("Invalid Age");

          }

          System.out.println("Enter Your Gender  :");
          String gender=sc.next();
          if ((gender.equalsIgnoreCase("male"))||(gender.equalsIgnoreCase("female"))){
               passengerGender=gender;
          }else {
               throw new Exception("Invalid Gender");
          }
//          PNR
           pnr  = rand.nextInt(100000,999999);



     }
     void userData(){
//         File myfile = new File("Initial_Java_Projects/src/Railway_Reservation_System/userDate.txt");
          try {
               passengersDetail();

                    Scanner sc =  new Scanner(new File("Initial_Java_Projects/src/Railway_Reservation_System/userDate.txt"));
                    boolean found = true;
                    while(sc.hasNextLine()){
                         String line = sc.nextLine();
                         String[] data = line.split(",");
                         if(data[0].equalsIgnoreCase(passengerName)){
                              System.out.println("Passenger Founded");
                              try {
                                   searchTrain();
                              } catch (Exception e) {
                                   System.out.println(e.getMessage());
                                   return;
                              }

                              passengerfile();
                              found=false;
                              break;

                         }
                    }
                    if(found){
                         System.out.println("Passenger is not Registered...");
                         System.out.println("Registered First");
                    }


          } catch (Exception e) {
               System.out.println(e.getMessage());
          }


     }

     void searchTrain()throws Exception {
          System.out.println("Enter Train Name : ");
          sc.nextLine();// read leftover lines
          trainName=sc.nextLine();
          if(trainName==""){
               throw new Exception("Cannot be Empty");
          }


          System.out.println("Train No. : ");
          try {
               trainN0=sc.nextInt();
          } catch (Exception e) {
               throw new Exception(e);
          }



          System.out.println("Enter source : ");
          sc.nextLine();
          source=sc.nextLine();
          if(source==""){
               throw new Exception("Cannot be empty");
          }
          System.out.println("Enter Destination : ");

          Destination=sc.nextLine();
          if(Destination==""){
               throw new Exception("Cannot be Empty");
          }
          try{
               Scanner scv = new Scanner(new File("Initial_Java_Projects/src/Railway_Reservation_System/train.Data.txt"));
               while(scv.hasNextLine()){
                    String line = scv.nextLine();
                    String [] data = line.split(",");
                    if(data[0].equalsIgnoreCase(trainName)||data[3].equals(String.valueOf(trainN0))){
                         if(data[1].equalsIgnoreCase(source)){
                              System.out.println("Train Found");
                              System.out.println("Ticked Booked ");
                              System.out.println("Your PNR : "+pnr);
                         }else{
                              System.out.println("Source  not matched");
                         }
                        return;

                    }

               }
               System.out.println("Train Not Found");
          }catch (IOException e){
               System.out.println(e);
          }

     }
     void passengerfile(){
          File myfile = new File("Initial_Java_Projects/src/Railway_Reservation_System/passengerDetail.txt");
          try{
//               myfile.createNewFile();
//               System.out.println("created");
               FileWriter fw =  new FileWriter("Initial_Java_Projects/src/Railway_Reservation_System/passengerDetail.txt",true);

              fw.write(passengerName+","+passengerAge+","+trainName+","+trainN0+","+source+","+Destination+","+pnr+"\n");


               fw.close();
//               myfile.delete();


          }catch (IOException e){
               System.out.println(e);
          }
     }


}
