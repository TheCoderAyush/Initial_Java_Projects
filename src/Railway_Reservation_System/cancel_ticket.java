package Railway_Reservation_System;

import java.io.File;
import java.io.FileWriter;
import java.sql.SQLOutput;
import java.util.Scanner;

public class cancel_ticket {
    int pnr;

    void cancelTicket() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Your PNR N0. : ");
        try {
            pnr = sc.nextInt();
        } catch (Exception e) {
            System.out.println(e);

        }
    }
    void deleteFunction(){
        cancelTicket();
        boolean found = false;
        try {
            Scanner scv = new Scanner(new File("Initial_Java_Projects/src/Railway_Reservation_System/passengerDetail.txt"));
            File myfile = new File("Initial_Java_Projects/src/Railway_Reservation_System/passengerDetail.txt");
            File deleteFile = new File("Initial_Java_Projects/src/Railway_Reservation_System/deletePassenger.txt");
            deleteFile.createNewFile();
            FileWriter fw= new FileWriter(deleteFile);

            while(scv.hasNextLine()){
                String line =  scv.nextLine();
                String [] data = line.split(",");
                if(data[6].equals(String.valueOf(pnr))){
                    System.out.println("PNR Matched....");
                   found=true;
                }
                else {
                    fw.write(line+"\n");


                }

            }
            fw.close();
            scv.close();

            if (found){
                Scanner sc = new Scanner(System.in);
                System.out.println("Are you sure : (Y/N)");
                String confirm= sc.nextLine();
                if(confirm.equalsIgnoreCase("Y")){
                    myfile.delete();
                    deleteFile.renameTo(myfile);
                    System.out.println("Ticket is Cancelled......");
                }else{
                    System.out.println("Ticket is not Cancelled.....");
                    System.out.println("Thank You.....");
                }

            }else{
                deleteFile.delete();
                System.out.println("Not valid  PNR");
                System.out.println("Passenger Not Found..... ");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}