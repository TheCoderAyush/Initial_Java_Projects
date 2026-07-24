package Railway_Reservation_System.services;

import Railway_Reservation_System.inputValidationUtil.InvalidInput;
import Railway_Reservation_System.model.Passenger;
import Railway_Reservation_System.model.Train;
import Railway_Reservation_System.util.FileUtil;
import Railway_Reservation_System.util.Input;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static Railway_Reservation_System.util.FileUtil.myfile2;

public class ViewBookings {
    public static void viewBookingByPnr() {
        System.out.println("Enter Your Pnr N0. : ");
        long pnr = Input.sc.nextLong();
        if (InvalidInput.isUniquePnr(pnr)) {
            try (Scanner scv = new Scanner(myfile2)) {
                String line;
                while (scv.hasNextLine()) {
                    line = scv.nextLine();
                    String[] data = line.split(",");
                    if (pnr == Integer.parseInt(data[3])) {
                        System.out.println("Passenger Name : " + data[0]);
                        System.out.println("Passenger Age : " + data[2]);
                        System.out.println("Passenger Gender : " + data[1]);
                        System.out.println("Passenger PNR N0.  : " + data[3]);
                        System.out.println("Trian Name  : " + data[6]);
                        System.out.println("Source  : " + data[4]);
                        System.out.println("Destination : " + data[5]);
                        break;
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println(e);
            }

        } else {
            System.out.println("PNR Not Exits.......");

        }
    }

    public static void viewAllBooking() {
        try (Scanner scv = new Scanner(myfile2)) {
            String line;
            while (scv.hasNextLine()) {
                line = scv.nextLine();
                String[] data = line.split(",");
                System.out.println("Passenger Name : "+data[0]+" || Source :"+data[4]+" || Destination :"+data[5] +" || Train Name :"+data[6] +" || PNR N0. : "+data[3]);
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

    }

    public static void main(String[] args) {
        viewAllBooking();
    }
}
