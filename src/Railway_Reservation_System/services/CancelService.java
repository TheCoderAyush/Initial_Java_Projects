package Railway_Reservation_System.services;

import Railway_Reservation_System.inputValidationUtil.InvalidInput;
import Railway_Reservation_System.util.Input;

public class CancelService {
    public static void cancelTicket(){
        System.out.println("Enter Your Pnr N0. : ");
        long pnr = Input.sc.nextLong();

        if(InvalidInput.isUniquePnr(pnr)){
            System.out.println("Got");
        }else {
            System.out.println("Not got");
        }

    }

    public static void main(String[] args) {
        cancelTicket();
    }
}
