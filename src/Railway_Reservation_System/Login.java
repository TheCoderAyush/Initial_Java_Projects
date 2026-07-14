package Railway_Reservation_System;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

class Login extends Registration {
    Scanner sc = new Scanner(System.in);
    String LoginUser;
    String LoginPassword;

    String checkUsername() {
        System.out.println("Enter Your Name : ");
        LoginUser = sc.nextLine();
        return LoginUser.toLowerCase();

    }

    String checkPassword() {
        System.out.println("Enter Your  Password : ");
        LoginPassword = sc.nextLine();
       return LoginPassword;
    }

    void readFiles() {
        try {
            File myfile = new File("Initial_Java_Projects/src/Railway_Reservation_System/userDate.txt");
            String searchUser=checkUsername();
            String checkPass=checkPassword();
            Scanner sc = new Scanner(myfile);

            while (sc.hasNextLine()) {
                String line= sc.nextLine();
                String []  user = line.split(",");

                if(user[0].equalsIgnoreCase(searchUser)){
                    if(user[1].equals(checkPass)){
                        System.out.println("User Found");
//                        nextFunction();
                    }else{
                        System.out.println("Password is Incorrect");
                    }
                    return;
                }

            }
            System.out.println("User is not Registered");
            System.out.println("Registration Required ....");


        } catch (IOException e) {
            System.out.println(e);
        }


    }
//    void nextFunction(){
//        book_ticket pass1=new book_ticket();
//        view_ticket passenger = new view_ticket();
//        cancel_ticket passengers = new cancel_ticket();
//        System.out.println("What Do You Want to Do -> ");
//        System.out.println("1 -> Book Ticket ");
//        System.out.println("2 -> View Ticket ");
//        System.out.println("3 -> Cancel Ticket ");
//        System.out.println("4 -> Exit");
//        int input=sc.nextInt();
//
//        switch (input) {
//
//            case 1:
//                System.out.println("-----------Booking Center---------\n");
//               pass1.userData();
//
//
//                break;
//            case 2:
//                System.out.println("-----------View Ticket Center---------\n");
//                passenger.viewTicket();
//
//                break;
//            case 3:
//                System.out.println("-----------Cancel Ticket Center---------\n");
//                passengers.deleteFunction();
//
//                break;
//            case 4:
//                System.out.println("Exited");
//                System.out.println("Program Ended");
//
//                break;
//            default:
//                System.out.println("Invalid Input....");
//                break;
//        }
//    }

    }



