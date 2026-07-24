package Railway_Reservation_System.services;

import Railway_Reservation_System.inputValidationUtil.InvalidInput;
import Railway_Reservation_System.util.FileUtil;
import Railway_Reservation_System.util.Input;
import java.util.InputMismatchException;

public class CancelService {
    public static void cancelTicket(){
        try{
            System.out.println("Enter Your Pnr N0. : ");
            long pnr = Input.sc.nextLong();
            if(InvalidInput.isUniquePnr(pnr)){
                if (FileUtil.changingFile(pnr)){
                    System.out.println("Ticket Cancelled Successfully........");
                }
            }else {
                System.out.printf("Passenger with PNR (%d) not Found....",pnr);
            }
        }catch (InputMismatchException e){
            System.out.println("Input Mismatch ");
        }
    }
}
