package Railway_Reservation_System.services;
import Railway_Reservation_System.exceptions.InvalidName;
import  Railway_Reservation_System.util.Input;
import Railway_Reservation_System.inputValidationUtil.InvalidInput;

public class LoginServices {
    public static void login(){
        try {
            System.out.println("Enter Your Name : ");
            String userName=Input.sc.nextLine();
            if (!InvalidInput.isValidName(userName)){
                throw new InvalidName("Invalid Name......");
            }
            if (InvalidInput.isSameName(userName)){
                System.out.println("User Found");
            }else{

                throw new InvalidName("User not Found: \n Register First...");
            }

            System.out.println("Enter Your Password : ");
            String password=Input.sc.nextLine();
            if (InvalidInput.isCorrectPassword(password)){
                System.out.println("Logging Successfully....");
            }else{
                System.out.println("Incorrect Password");
            }
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
