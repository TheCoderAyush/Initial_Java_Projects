package Railway_Reservation_System.util;

import Railway_Reservation_System.services.*;

import java.util.InputMismatchException;

public class Menu {

    public static void start(){
        System.out.println("\t\t\t-------Welcome to Indian Railway Reservation System--------");

        System.out.println("What You Want To Do : ");
        System.out.println(" 1 -> Register");
        System.out.println(" 2 -> Login");
        System.out.println("Give Input : ");
        int input=0;
            try {
                input = Input.sc.nextInt();
                Input.sc.nextLine();
            }catch (InputMismatchException e){
                System.out.println(e);
            }
                 switchFunction(input);
    }
    public static void switchFunction(int input){

        switch (input){
            case 1 :
                System.out.println("\t\t--------Registration Counter---------");
                RegistrationService.register();
                break;
            case 2 :
                System.out.println("\t\t-----------Login Counter-------------");
                LoginServices.login();
                break;
            default:
                System.out.println("Invalid Input...........");
                break;
        }

    }
    public static void afterLogin(){
        System.out.println("What do You Want to Do : ");
        System.out.println(" 1 -> Book Ticket \n 2 -> Cancel Ticket \n 3 -> View Ticket \n 4 -> View All Trains \n 5 -> Exit ");
        System.out.println("Give Input : ");
        int input=0;
        try {
             input = Input.sc.nextInt();
             Input.sc.nextLine();
        }catch (InputMismatchException e){
            System.out.println(e);
        }

        switch (input){
            case 1:
                System.out.println("\t\t-------Booking Counter--------");
                BookingService.bookTicket();
                break;
            case 2:
                System.out.println("\t\t--------Cancellation Counter-------");
                CancelService.cancelTicket();
                break;
            case 3:
                System.out.println("\t\t---------View Counter-------------");
                ViewBookings.viewBookingByPnr();
                break;
            case 4:
                System.out.println("\t\t------------View All Available Train---------------");
                TrainServices.displayAllTrain();
                break;
            case 5:
                return;
            default:
                System.out.println("Invalid Input.........");

        }
    }

    public static void main(String[] args) {
        afterLogin();
    }
}
