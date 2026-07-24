package Railway_Reservation_System.services;

import Railway_Reservation_System.exceptions.InvalidEmail;
import Railway_Reservation_System.exceptions.InvalidName;
import Railway_Reservation_System.exceptions.InvalidSex;
import Railway_Reservation_System.model.User;
import Railway_Reservation_System.util.Input;
import Railway_Reservation_System.util.FileUtil;
import Railway_Reservation_System.exceptions.InvalidAge;
import Railway_Reservation_System.inputValidationUtil.InvalidInput;

public class RegistrationService {
   public static void register()
   {
        try {


             System.out.println("Enter Your Name : ");
             String Name;
             String name = Input.sc.nextLine();

             if (InvalidInput.isValidName(name)) {
                  if (InvalidInput.isSameName(name.trim())){
                       throw new InvalidName("UserName already exits");
                  }else {
                       Name=name.replaceAll("\\s+"," ");
                  }

             }else{
                throw new InvalidName("Invalid Name.......");
             }

             System.out.println("Enter Your Age : ");
             int age;
             age = Input.sc.nextInt();
             if (!InvalidInput.isValidAge(age)) {
                  throw new InvalidAge("Invalid Age");
             }
             System.out.println("Enter Your Sex : ");

             String sex = Input.sc.next();

             if (!InvalidInput.isValidSex(sex)) {
                  throw new InvalidSex("Invalid SEX.....");
             }
             Input.sc.nextLine();
             System.out.println("Enter Your Email : ");

             String email = Input.sc.nextLine();
             if (!InvalidInput.isValidEmail(email)) {

                  throw new InvalidEmail("Invalid Email");
             }
             if (InvalidInput.isSameEmail(email.trim())){
                  throw new InvalidEmail("Email Already exists");
             }

             System.out.println("Create Your Password : ");
             String password = Input.sc.nextLine();
             System.out.println();
             System.out.println("Registration Successful........");

//        User Object
             User user = new User(Name.trim(), password, email, sex, age);
//         saveUser
             FileUtil.saveUser(user);

        }catch (Exception e){
             System.out.println(e.getMessage());
        }
    }
}
