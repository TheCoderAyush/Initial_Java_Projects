package Railway_Reservation_System.services;
import Railway_Reservation_System.inputValidationUtil.InvalidInput;
import Railway_Reservation_System.util.FileUtil;
import Railway_Reservation_System.util.Input;
import Railway_Reservation_System.util.PnrGeneration;
import Railway_Reservation_System.exceptions.InvalidAge;

import Railway_Reservation_System.exceptions.InvalidName;
import Railway_Reservation_System.exceptions.InvalidSex;
import Railway_Reservation_System.model.Passenger;
import Railway_Reservation_System.model.Train;
import Railway_Reservation_System.util.TrainFile;

import java.util.InputMismatchException;

public class BookingService {
    public static void bookTicket() {
        try {


            System.out.println("Enter Your Name : ");
            String name = Input.sc.nextLine();
            String Name =name.replaceAll("\\s+","");
            if (!InvalidInput.isValidName(name)) {
                throw new InvalidName("Invalid Name.....");
            }

            System.out.println("Enter your Age : ");
            int age = Input.sc.nextInt();
            if(!InvalidInput.isValidAge(age)){
                throw new InvalidAge("Invalid age.....");
            }
            Input.sc.nextLine();
            System.out.println("Enter Your Sex : ");
            String sex = Input.sc.nextLine();
            if (!InvalidInput.isValidSex(sex)){
                throw new InvalidSex("It should male or female");
            }

                Train t = TrainServices.searchTrain();
                if(t.getTrainNo()==0){
                    Passenger pass = new Passenger(Name,sex,age,(PnrGeneration.pnr()));

                    FileUtil.bookingData(pass,t);
                    System.out.println("Ticket is Booked......");
                    if (InvalidInput.isUniquePnr(PnrGeneration.pnr())){
                        System.out.println("Your Pnr N0. is : "+PnrGeneration.pnr() );
                    }else{
                        long pnr = PnrGeneration.pnr();
                        System.out.println("Your Pnr N0. is : "+PnrGeneration.pnr());
                    }
                }else {
                    throw new InputMismatchException();
                }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
