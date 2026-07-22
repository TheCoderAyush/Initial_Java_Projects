package Railway_Reservation_System.inputValidationUtil;
import Railway_Reservation_System.model.Passenger;
import Railway_Reservation_System.model.Train;
import Railway_Reservation_System.services.TrainServices;
import Railway_Reservation_System.util.FileUtil;
import Railway_Reservation_System.model.User;

public class InvalidInput {
    public static boolean isValidName(String name){
        return name.matches("[a-z A-Z]+");
    }
    public static boolean isValidAge(int age){
        if ((age<0)||(age>120)){
            return false;
        }else {
            return true;
        }

    }
    public static boolean isValidSex(String sex){
        if (sex.equalsIgnoreCase("male")||sex.equalsIgnoreCase("female")){
            return true;
        }else {
            return false;
        }
    }
    public static boolean isValidEmail(String email){
        if (email.endsWith("@gmail.com")){
            return true;
        }else{
            return false;
        }
    }
    public static boolean isSameName(String name){
        for (User user : FileUtil.getAllUser()){
            if (name.equalsIgnoreCase(user.getUserName())){
                return true;
            }
        }
        return false;
    }
    public static boolean isSameEmail(String email){
        for (User user : FileUtil.getAllUser() ){
            if (email.equalsIgnoreCase(user.getEmail())){
                return true;
            }
        }
        return false;
    }
    public static boolean isCorrectPassword(String pass){
        for (User user : FileUtil.getAllUser()){
            if (pass.equals(user.getPassword())){
                return true;
            }
        }
        return false;
    }
    public static boolean isUniquePnr(long pnr){
        for (Passenger pass : FileUtil.getBookedPassenger()) {
            if (String.valueOf(pnr).equals(String.valueOf(pass.getPnr()))) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

    }




}
