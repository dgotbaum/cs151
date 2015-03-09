import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author James Capuder and Jack Benson
 */
public abstract class MazeSolver {
    private Maze x;
    public Maze childMaze;
    private boolean isSolved = false;
    private String finalPath = "";
    private Square [][] childMazeArray;

    public abstract void makeEmpty();

    public abstract boolean isEmpty();

    public abstract void add(Square sq);

    public abstract Square remove();

    public abstract Square getNext();

    public MazeSolver(Maze maze){
        childMaze = maze;
        childMazeArray = childMaze.getMazeArray();
    }

    public boolean isSolved(){
        if (childMaze.getFinish().getSquarePrevious() == null) return false;
        else {
            // build the path backwards from Finish
            Square x = childMaze.getFinish().getSquarePrevious();
            while (x.getType()!= Square.START&& x.getType()!=Square.WALL){
                x.typeSet(6);
                //System.out.println(x.toString());
                x = x.getSquarePrevious();
            }
            return true;
        }
    }

    public String getPath(){
         //if (!childMaze.solvable) return "Not Solvable";
         if (isSolved()){
             for (int row=0; row < childMaze.getNumRows(); row++) {
                 for (int col = 0; col < childMaze.getNumCols(); col++) {
                     if (childMazeArray[row][col].getType() == 6){
                         finalPath += "["+Integer.toString(row) +", "+ Integer.toString(col) + "]->";
                     }
                 }
             }
             return finalPath;
         } else{
             return "This maze is unsolvable";
         }
    }

    public Square step() {
        if(isEmpty()) {
            childMaze.solvable = false;
            return null;
        }
        Square next = getNext();
        if (next == childMaze.getFinish())
            return next;
        for (Square neighbor : childMaze.getNeighbors(next)) {
            if (!neighbor.isMarked() && neighbor != childMaze.getStart()) {
                neighbor.setSquarePrevious(next);
                if (neighbor == childMaze.getFinish()) {
                    return  next;
                }
                else {
                    neighbor.typeSet(4);
                    add(neighbor);
                }
            }
        }
        if (next.getType() != 1 && next.getType() !=2) next.typeSet(5);
        return next;
    }

    public void solve(){
        add(childMaze.getStart());
        while (!isSolved()){
            step();
            if (isEmpty() && childMaze.getFinish().getSquarePrevious()==null) break;
        }
    }


}
