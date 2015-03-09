import java.util.Scanner;
import java.util.Random;


/**
 * Part 3: What number am I thinking of?
 * @author James Capuder
 * 2/14/15
 * CS151 Lab1 HiLo.java
 * A simple numeric guessing game. Computer picks a number between 1 and 1000, the user then attempts to guess what the
 * number is.
 * I affirm that I have adhered to the honor code in this assignment.
 */



public class HiLo {
    public static void main(String[] args) {
        System.out.println("Welcome to the HiLo guessing game.\n In this game, the computer will generate" +
                " a number between 1 and 1000. \n It will be your job to guess the number. Good luck!");
        Random rando = new Random();
        int target = rando.nextInt(1000)+1;
        int userGuess = -1;
        int guessCount = 0;
        System.out.println("Please enter a guess:");
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine() ){
            guessCount += 1;
            String line = input.nextLine();
            Scanner s2 = new Scanner(line);

            if (s2.hasNextInt()){
                userGuess = s2.nextInt();
                if (userGuess < target) {
                    System.out.println("Your guess was too low!\n Enter a guess:");
                } else if (target < userGuess) {
                    System.out.println("Your guess was too high!\n Enter a guess:");
                } else {
                    System.out.println("You guessed it! It took you " + guessCount + " tries");
                    break;
                }
            } else{
                System.out.println("Sorry! Your input must be an integer.\n Enter a guess:");
                continue;
            }
        }

    }
}
