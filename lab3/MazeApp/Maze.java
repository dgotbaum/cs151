/**
 * Sets up a maze
 * @author James Capuder and Jack Benson
 */
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Maze {
    private int numCols;
    private int numRows;
    private Square[][] mazeArray;
    private Square startSquare;
    private Square finishSquare;
    public boolean solvable = true;

    /**
     * Reads in a text maze to initializes a maze object as a 2d array of squares.
     * @param fName - Name of the file
     * @return True if maze was successfully loaded.
     * @throws FileNotFoundException accordingly.
     */

    public boolean loadMaze(String fName){
        try{
            Scanner MAZE = new Scanner(new File(fName));
            numRows = MAZE.nextInt();
            numCols = MAZE.nextInt();
            mazeArray = new Square[numRows][numCols];
            for (int row=0; row < numRows; row++){
                for (int col=0; col<numCols; col++){
                    mazeArray[row][col] = new Square(MAZE.nextInt(), row, col);
                    if (mazeArray[row][col].toString() == "S"){startSquare = mazeArray[row][col];}
                    if (mazeArray[row][col].toString() == "E"){ finishSquare = mazeArray[row][col];}
                }
            }
            System.out.println(mazeArray.length);
            reset();
            return true;
        } catch (FileNotFoundException e) {
            return false;
        }
    }

    /**
     * Gets all the neighbors of a given square. If statements to check if the square is on an edge of the maze,
     * and make sure that the neighboring square isn't a wall. Stores them all in the ArrayList "neighbors."
     * @param sq - The square that you want the neighbors of.
     * @return neighbors - The ArrayList of neighbors.
     */

    public ArrayList<Square> getNeighbors(Square sq){
        int rowValue = sq.getRow();
        int colValue = sq.getCol();
        ArrayList<Square> neighbors = new ArrayList<Square>();
        if (!(colValue==0)&& sq.getType()!=1)neighbors.add(mazeArray[rowValue][colValue-1]);
        if (!(rowValue==numRows-1)&& sq.getType()!=1)neighbors.add(mazeArray[rowValue+1][colValue]);
        if (!(colValue==numCols-1)&& sq.getType()!=1)neighbors.add(mazeArray[rowValue][colValue+1]);
        if (!(rowValue==0) && sq.getType()!=1) neighbors.add(mazeArray[rowValue-1][colValue]);
        return neighbors;
    }

    /**
     * Gets the start square of the maze.
     * @return The start square.
     */

    public Square getStart(){
        return startSquare;
    }

    /**
     * Gets the exit square of the maze.
     * @return finishSquare - The exit square.
     */

    public Square getFinish(){
        return finishSquare;
    }

    /**
     * Resets the maze to its initial configuration. Used by Mazeapp.
     */

    public void reset(){
        for (int row=0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                mazeArray[row][col].resetType();
            }
        }
    }

    /**
     * Creates a string representation of the maze.
     * @return mazeString
     */

    public String toString(){
        String mazeString = "";
        for (int row=0; row < numRows; row++){
            for (int col=0; col<numCols; col++){
                mazeString += mazeArray[row][col].toString();
            }
            mazeString += "\n";
        }
        return mazeString;
    }

    /**
     * @return numCols - Number of columns of the maze.
     */

    public int getNumCols(){
        return numCols;
    }

    /**
     * @return numRows - Number of rows of the maze.
     */

    public int getNumRows(){
        return numRows;
    }

    /**
     * @return mazeArray - The 2d Array of squares at the heart of each maze.
     */

    public Square[][] getMazeArray(){
        return mazeArray;
    }


}
