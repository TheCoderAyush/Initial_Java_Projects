package Railway_Reservation_System.model;

public class User {
    private  String userName;
    private String password;
    private String email;
    private String gender;
    private int age;
   public  User( String userName,String password,String email,String gender,int age){
         this.userName=userName;
         this.password=password;
         this.email= email;
         this.gender=gender;
         this.age = age;

     }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }
    public int getAge(){
        return age;
    }
}
