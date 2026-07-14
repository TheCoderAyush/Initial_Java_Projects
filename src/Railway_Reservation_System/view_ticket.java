package Railway_Reservation_System;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class view_ticket {
    int pnr;
    void viewTicket(){
        Scanner sc =  new Scanner(System.in);
        System.out.println("Enter Your PNR N0. : ");
        try {
             pnr=sc.nextInt();
        }catch (Exception e){
            System.out.println(e);
            return;
        }

        try {
            Scanner scv = new Scanner(new File("Initial_Java_Projects/src/Railway_Reservation_System/passengerDetail.txt"));
            while(scv.hasNextLine()){
                String line = scv.nextLine();
                String[] userData=line.split(",");

                if(userData[6].equals(String.valueOf(pnr))){
                    System.out.println("Passenger Found \n");
                    System.out.println("----------Details-------------\n");
                    System.out.println("Passenger Name : "+userData[0]);
                    System.out.println("Passenger Age : "+userData[1]);
                    System.out.println("Train Name : "+userData[2]);
                    System.out.println("Train N0. : "+userData[3]);
                    System.out.println("Source of Train : "+userData[4]);
                    System.out.println("Destination of Train  : "+userData[5]);
                    System.out.println("PNR N0. : "+userData[6]);
                    return;
                }

            }
            System.out.println("Passenger Not Found......");
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
