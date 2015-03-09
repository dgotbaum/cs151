/**
 * Square class to represent a square of a maze.
 * I affirm that I have adhered to the honor code in this assignment.
 * @author James Capuder and Jack Benson
 */
import java.awt.Point;

public class Square {


    public static final int SPACE = 0;
    public static final int WALL = 1;
    public static final int START = 2;
    public static final int EXIT = 3;
    public static final int WORKLIST = 4;
    public static final int EXPLORED = 5;
    public static final int FINALPATH = 6;


    Point location;
    private int squareType;
    private int finalType;
    private Square squarePrevious;



    /**
     * Constructor for square object.
     * @param typeInt -  Integer value representing the type of square.
     * @param Row Row value, to set "X" coordinate of square in maze.
     * @param Column Column value, to set "Y" value of square in maze.
     */

    public Square(int typeInt, int Row, int Column){
        squareType = typeInt;
        location = new Point(Row, Column);
        finalType = typeInt;
        squarePrevious = null;
    }

    /**
     * Takes the square type and makes a string representation.
     * @return String representation of the type of square
     */

    public String toString(){
        switch(squareType){
            case SPACE:
                return "_";
            case WALL:
                return "#";
            case START:
                return "S";
            case EXIT:
                return "E";
            case WORKLIST:
                return "o";
            case EXPLORED:
                return ".";
            case FINALPATH:
                return "x";
            default:
                return "None";
        }
    }

    /**
     * Gets the type of a square
     * @return squareType, the integer representation of the square.
     */

    public int getType(){
        return squareType;
    }

    /**
     * Method to set the square type to WORKLIST, EXPLORED, or FINALPATH
     * @param newType
     */

    public void typeSet(int newType){
        squareType = newType;
    }

    /**
     * Sets the type of the square back to it's initial type (so not WORKLIST, EXPLORED, or FINALPATH).
     */

    public void resetType(){
        squareType = finalType;
    }

    /**
     * Gets the row coordinate of the square
     * @return The row coordinate
     */

    public int getRow(){
        int X = (int) location.getX();
        return X;
    }

    /**
     * Gets the column coordinate of the square
     * @return The column coordinate
     */
    public int getCol(){
        int Y = (int) location.getY();
        return Y;
    }

    /**
     * isMarked method checks to see if the square is already explored, a wall, or on the worklist (to be explored). This aids
     * in determining a final path and making sure walls are considered walls.
     * @return True if the square has been marked or is a wall.
     */

    public boolean isMarked(){
        if (squareType == 4 || squareType == 5 || squareType == WALL){
            return true;
        } else{
            return false;
        }
    }

    /**
     * setSquarePrevious method sets the class variable that indicates which square added it to the worklist. Necessary for
     * determining a final path.
     * @param sq - The square to be set as "squarePrevious"
     */

    public void setSquarePrevious(Square sq){
        squarePrevious = sq;
    }

    /**
     * A method to get a square's "squarePrevious." Used in constructing the final path.
     * @return the "squarePrevious"
     */

    public Square getSquarePrevious(){

        return squarePrevious;
    }

}
