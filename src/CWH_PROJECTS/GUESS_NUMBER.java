package CWH_PROJECTS;

import java.util.*;

class Game{
   public  int randomNumber;
   public  int userNumber;
   public  int noOfGuesses;
   public  int Guesses;
   //Constructor
    public Game(){
        Random rn = new Random();
         randomNumber= rn.nextInt(0,11);
    }
    // Taking user Input
    public void takeUserInput(){
        Scanner sc= new Scanner(System.in);
            System.out.println("Give Your Number:- ");
            userNumber = sc.nextInt();
    }
    // Setting no. of Guess

    public void setNoOfGuesses(){

            Guesses++;
        this.noOfGuesses=Guesses;
    }
    //comparing
    public void isCorrectNumber(){
        if (userNumber==randomNumber){
            System.out.println("Bravo..You Guessed it right!");
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
    //getting no. of Guesses

    public int getNoOfGuesses() {
        return noOfGuesses;
    }
    // Nalla Adami
    public void nalla(){
        if ( noOfGuesses>4){
            System.out.println("MARGA BHAI AUR CODING CHHOD DE");
        }else{
            System.out.println("Finally.. You Guessed it!");
        }
    }
}
public class GUESS_NUMBER {
    public static void main(String[] args) {
        Game clue= new Game();
        //Printing random number
        System.out.println("Random Number is: "+clue.randomNumber);

        System.out.println("  --------------------Let The Game Begin--------------------");
        System.out.println();
        System.out.println("  --------------------GUESS THE NUMBER--------------------");
        System.out.println();
        System.out.println("Choose Number Between 1 and 10");
        System.out.println();

        clue.takeUserInput();


        clue.isCorrectNumber();

        clue.setNoOfGuesses();

        System.out.println();

        System.out.println("The Number of Guesses :"+clue.getNoOfGuesses());

        clue.nalla();




    }

}
