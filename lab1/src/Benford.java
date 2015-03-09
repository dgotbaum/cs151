/**
 * Part 5: Bedford Analysis
 * @author James Capuder
 * 2/14/15
 * CS151 Lab1 Benford.java
 *Bedford Analysis Program
 * I affirm that I have adhered to the honor code in this assignment.
 */
import java.io.FileNotFoundException;
import java.util.*;
import java.io.File;
public class Benford {
    public static final int maximumWidth = 50;
    public static void main(String[] args) {
        Scanner input = null;
        int[] digitCountArray = new int[10];
        try {

            input = new Scanner(new File(args[0]));
            while (input.hasNext()) {
                String wholeString = input.next();
                String leadingDigit = wholeString.substring(0, 1);
                if (Character.isDigit(wholeString.charAt(0))) {
                    int a =Integer.parseInt(leadingDigit);
                    digitCountArray[a]++;
                }
            }
            int Max = -1;
            int count = 0;
            for(int i : digitCountArray) {
                count+=i;
                if (i > Max) Max = i;
            }
            System.out.println("Welcome to my Benford analysis program. Below is a histogram representing " +
                    "frequency distributions of digits in the text file you entered.");
            for (int i = 0; i < digitCountArray.length; i++) {
                float frequencyOfDigits = (float)digitCountArray[i]/(float)count*(float)100.0;
                System.out.printf("%d %8d %4.1f%% : ", i, digitCountArray[i], frequencyOfDigits);
                for (int bins =  0; bins < (maximumWidth*digitCountArray[i]/Max); bins++)
                    System.out.print("*");
                System.out.println();
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Whoops, no file " + e.getMessage()+" found.");
            System.exit(1);
        }
    }
}

