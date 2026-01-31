package CWH_PROJECTS;
import java.util.*;
public class Rock_Paper_Scissor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rn = new Random();
        int computerSide = 0;
        int userSide = 0;

        System.out.println("Rules:-");
        System.out.println();
        System.out.println("0:-for Rock");
        System.out.println("1:-for Paper");
        System.out.println("2:-for Scissor");
        System.out.println();
        int userNumber;

        for (int i = 1; i <= 3; i++) {
            System.out.println();
            System.out.println("Round:- " + i);
            System.out.println("Give Your Number :- ");

            userNumber = sc.nextInt();

            if (userNumber >= 3) {
                System.out.println("Invalid Number..");
                System.out.println("Play Again...");
                break;
            } else {
                System.out.println("Your Turn...");
                if (userNumber == 0) {
                    System.out.println(" Rock");
                } else if (userNumber == 1) {
                    System.out.println(" Paper");
                } else if (userNumber == 2) {
                    System.out.println(" Scissor");
                }
//            else {
//                System.out.println("Invalid");
//            }

                int random = rn.nextInt(0, 3);
//            System.out.println();
                System.out.println("Computer Turn...");

                if (random == 0) {
                    System.out.println(" Rock");
                } else if (random == 1) {
                    System.out.println(" Paper");
                } else if (random == 2) {
                    System.out.println(" Scissor");
                }

                System.out.println();

                System.out.println(" Result of the Round :-" + i);
                if (userNumber == random) {
                    System.out.println(" Draw ");
                } else if (userNumber < random) {
                    System.out.println(" Computer Win .. ");
                    computerSide++;
                } else {
                    System.out.println(" You Win ");
                    userSide++;
                }

            }
        }
        System.out.println();

        System.out.println("Game Winner... is :-  ");
//        System.out.println();
        if (userSide == computerSide) {
            System.out.println(" Nobody Wins i.e Draw ");
        } else if (userSide > computerSide) {
            System.out.printf("  User..\n Score:- %d/3 ", userSide);
        } else {
            System.out.printf(" Computer.. \n Score:- %d/3 ", computerSide);
        }
    }
}

