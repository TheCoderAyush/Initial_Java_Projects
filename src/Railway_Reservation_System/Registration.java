package Railway_Reservation_System;



import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Registration {
    Random rn = new Random();
    Scanner sc = new Scanner(System.in);
   public String Username;
    String Phone_Number;
    String Password;
    String email;
    String Gender;



  public  void userDetail(){
        System.out.println("Enter Your Name: ");
        sc.nextLine();
        Username=sc.nextLine();
        System.out.println("Enter Your Gender : ");
        Gender=sc.nextLine();
        if(Username.matches("[a-zA-Z ]+")&&(Gender.matches("[a-zA-Z ]+"))){
//            System.out.println("Username : "+Username);
//            System.out.println("Gender : "+Gender);
        }else{
            System.out.println("Invalid Detail");

        }

    }
    void phoneNumber(){
        System.out.println("Enter Your Phone Number : ");
        Phone_Number=sc.nextLine();
//        System.out.println("Number : "+Phone_Number);
    }
    void userEmail(){
        System.out.println("Enter Your Email Id : ");
        String  Email=sc.nextLine();
        if (Email.endsWith("@gmail.com")){
          email=  Email.toLowerCase();
//            System.out.println(email);
        }else{
            System.out.println("Invalid Email");
        }

    }

    void createPassword(){
        userDetail();
        phoneNumber();
        userEmail();
        System.out.println("Create Your Password : ");
        Password=sc.nextLine();
        System.out.println("Confirm Password : ");
        String confirmPass=sc.nextLine();
        if(confirmPass.equals(Password)){
//            System.out.println("Password Created Successfully..");
            System.out.println("Registration Done Successfully...");
            UsersData();

        }else{
            System.out.println("Password not matches..");
        }
    }

    void UsersData(){
        File userFile = new File("Initial_Java_Projects/src/Railway_Reservation_System/userDate.txt");
        try {
            userFile.createNewFile();
//            System.out.println("created ");
            FileWriter UserFw= new FileWriter("Initial_Java_Projects/src/Railway_Reservation_System/userDate.txt",true);
            UserFw.write(Username.toLowerCase()+","+Password+","+email+","+Phone_Number+"\n");

            UserFw.close();
//            userFile.delete();

        }catch (IOException e){
            System.out.println(e);
        }

    }
    int menu(){
        System.out.println("0 -> Display Available Trains ");
        System.out.println("1 -> Registration ( New User ) ");
        System.out.println("2 -> Login ");
        System.out.println("3 -> Book Ticket");
        System.out.println("4 -> View Ticket");
        System.out.println("5 -> Cancel Ticket");
        System.out.println("6 -> Exit ");
        System.out.println("Give input :-> ");
        int input= sc.nextInt();
        return input;
    }
    void mainWorking(){
        Registration newUser= new Registration();
        Login userlogin = new Login();
        book_ticket pass1=new book_ticket();
        view_ticket passenger = new view_ticket();
        cancel_ticket passengers = new cancel_ticket();
        train_Detail trains = new train_Detail();

        System.out.println("-----------------Welcome to Railway Reservation System-------------------\n");

        System.out.println("<------------Operations--------->\n");

        boolean condition = true;
        while(condition) {


            int input = newUser.menu();
            switch (input) {
                case 0:
                    trains.displayTrain();
                    System.out.println("Want to Do Someting Else : (Y/N)");
                    String   again = sc.next();
                    if(again.equalsIgnoreCase("Y")){
                        condition=true;
                    }else{
                        System.out.println("Program Ended");
                        condition=false;
                    }
                    break;
                case 1:
                    System.out.println("-----------Registration Center---------\n");

                    newUser.createPassword();
                    System.out.println("Want to Do Someting Else : (Y/N)");
                     again = sc.next();
                    if(again.equalsIgnoreCase("Y")){
                        condition=true;
                    }else{
                        System.out.println("Program Ended");
                        condition=false;
                    }
                    break;
                case 2:
                    System.out.println("-----------Login Center---------\n");
                    userlogin.readFiles();
                    System.out.println("Want to Do Someting Else : (Y/N)");
                    again = sc.next();
                    if(again.equalsIgnoreCase("Y")){
                        condition=true;
                    }else{
                        System.out.println("Program Ended");
                        condition=false;
                    }
                    break;
                case 3:
                    System.out.println("-----------Booking Center---------\n");
                    pass1.userData();
                    System.out.println("Want to Do Someting Else : (Y/N)");
                    again = sc.next();
                    if(again.equalsIgnoreCase("Y")){
                        condition=true;
                    }else{
                        System.out.println("Program Ended");
                        condition=false;
                    }


                    break;
                 case 4:
                     System.out.println("-----------View Ticket Center---------\n");
                        passenger.viewTicket();
                     System.out.println("Want to Do Someting Else : (Y/N)");
                     again = sc.next();
                     if(again.equalsIgnoreCase("Y")){
                         condition=true;
                     }else{
                         System.out.println("Program Ended");
                         condition=false;
                     }

                    break;
                 case 5:
                    System.out.println("-----------Cancel Ticket Center---------\n");
                    passengers.deleteFunction();
                     System.out.println("Want to Do Someting Else : (Y/N)");
                     again = sc.next();
                     if(again.equalsIgnoreCase("Y")){
                         condition=true;
                     }else{
                         System.out.println("Program Ended");
                         condition=false;
                     }

                    break;
                case 6:
                    System.out.println("Exited");
                    System.out.println("Program Ended");
                    condition = false;
                    break;
                default:
                    System.out.println("Invalid Input....");
                    break;
            }
        }
    }

    public static void main(String[] args) throws Exception {


      Registration passenger=new Registration();
      passenger.mainWorking();






    }
}
