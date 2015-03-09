import java.util.Scanner;

/**
 * @author James Capuder
 * 2/9/15
 * CS151 Lab1 Pyramid.java
 * Generate pyramids with * characters with height given by user.
 * I affirm that I have adhered to the honor code in this assignment.
 */
public class Pyramid {

    public static void main(String[] args) {
        if (args.length != 1){
            System.out.println("Your input must be a number between 1 and 9.");
            System.exit(1);
        } else {
            /*
            System.out.println("Please enter the desired height of the pyramid: ");
            Scanner input = new Scanner(System.in);
            String num = input.nextLine();
            int height = Integer.parseInt(num);*/
            int height = Integer.parseInt(args[0]);
            int max = (height*2)-1;
            for (int i=0; i<height; i++) {
                int stars = 1 + (i * 2);
                int spaces = (max - stars) / 2;
                for (int j = 0; j < spaces; j++) {
                    System.out.print(" ");
                }
                for (int z = 0; z < stars; z++) {
                    System.out.print("*");
                }
                for (int a = 0; a < spaces; a++) {
                    System.out.print(" ");
                }
                System.out.print("\n");
            }
        }
    }
}
