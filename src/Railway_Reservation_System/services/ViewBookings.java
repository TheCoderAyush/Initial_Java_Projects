package Railway_Reservation_System.services;

import Railway_Reservation_System.inputValidationUtil.InvalidInput;
import Railway_Reservation_System.model.Passenger;
import Railway_Reservation_System.model.Train;
import Railway_Reservation_System.util.FileUtil;
import Railway_Reservation_System.util.Input;

public class ViewBookings {
    public static void viewBookingByPnr() {
        System.out.println("Enter Your Pnr N0. : ");
        long pnr = Input.sc.nextLong();
        if(InvalidInput.isUniquePnr(pnr)){
            for (Passenger pass : FileUtil.getBookedPassenger()){
                System.out.print("Passenger Name : "+pass.getPassengerName()+","+"Passenger Age : "+pass.getPassengerAge()+","+"PNR N0. : "
                +pass.getPnr()+"\n");
            }
            for (Train train : FileUtil.getBookedTrain()){
                System.out.print("Train Name : "+train.getTrainName()+","+" Source : "+train.getSource()+","+" Destination : "+train.getDestination()+"\n");
            }
        }else{
            System.out.println("PNR Not Exits.......");

        }
    }
    public static void viewAllBooking(){
        for (Passenger pass : FileUtil.getBookedPassenger()){
            System.out.print("Passenger Name : "+pass.getPassengerName()+","+" PNR N0. : "
                    +pass.getPnr());
        }
        for (Train train : FileUtil.getBookedTrain()){
            System.out.print(", Train Name : "+train.getTrainName()+","+" Source : "+train.getSource()+","+" Destination : "+train.getDestination()+"\n");
        }
    }

    public static void main(String[] args) {
       viewAllBooking();
    }
}
