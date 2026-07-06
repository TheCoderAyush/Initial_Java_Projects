package CWH_PROJECTS;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

class Game{
   public  int randomNumber;
   public  int userNumber;
   public  int noOfGuesses;
   public  int Guesses;
   public String Name;
   //Constructor
    public Game(){
        Random rn = new Random();
         randomNumber= rn.nextInt(0,11);
    }

    public void takeUserInput(){
        Scanner sc= new Scanner(System.in);
            System.out.println("Give Your Number:- ");
            userNumber = sc.nextInt();
    }


    public void setNoOfGuesses(){

            Guesses++;
        this.noOfGuesses=Guesses;
    }

    public void isCorrectNumber(){
        if (userNumber==randomNumber){
            System.out.println("Bravo....You Guessed it right!");
            System.out.println();
            System.out.println("Good Job");
        }else{

            do {
            System.out.println("Wrong..Try Again");
                takeUserInput();
                setNoOfGuesses();
            }while (userNumber!=randomNumber);
        }
    }

    public int getNoOfGuesses() {

        return noOfGuesses;
    }

    public void doItBetter(){
        if ( noOfGuesses>4){
            System.out.println("You can do Better.");
        }else{
            System.out.println("Finally.. You Guessed it!");
        }
    }
    public void  createFile(){
        File data = new File("Initial_Java_Projects/src/CWH_PROJECTS/History.txt");
        try{
            data.createNewFile();
            System.out.println("File created Successfully");
        }catch(IOException e){
            System.out.println(e);
        }
//
    }
    public void  storeData(){
        try{
            FileWriter fw= new FileWriter("Initial_Java_Projects/src/CWH_PROJECTS/History.txt",true);
            fw.write("UserName : "+Name +"\n");
            fw.write("Your Number was : "+randomNumber+"\n");
            fw.write("Guesses : "+noOfGuesses + "\n");
            fw.write("\n");
            fw.close();


        }catch (IOException e){
            System.out.println(e);
        }

    }
    public void userName(){
        boolean condition = true;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Your Name : ");
        Name=sc.nextLine();
        if (Name.matches("[a-zA-Z ]+")){

            takeUserInput();
//            Checking correctness
            isCorrectNumber();

//    counting no. of Guesses
            setNoOfGuesses();

            System.out.println("The Number of Guesses :"+getNoOfGuesses());

            doItBetter();


//        Storing Data
          storeData();


        }else{
            System.out.println("Invalid name ! Give Valid Name ");
            System.out.println("Program Ended");
            condition = false;
        }


    }
}
public class GUESS_NUMBER {
    public static void main(String[] args) {
        Game clue= new Game();


        System.out.println("  --------------------Let The Game Begin--------------------");
        System.out.println();
        System.out.println("  --------------------GUESS THE NUMBER--------------------");
        System.out.println();
        System.out.println("Choose Number Between 1 and 10");
        System.out.println();


        clue.userName();

//        clue.createFile();
    }

}
