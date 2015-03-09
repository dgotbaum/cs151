/**
 *@author James Capuder and Jack Benson
 */
public class MazeSolverStack extends MazeSolver {
    private MyStack<Square> workList;



    public void makeEmpty() {
        workList = new MyStack<Square>();
    }


    public boolean isEmpty() {
        return workList.isEmpty();
    }

    public void add(Square sq) {
        workList.push(sq);
    }

    public Square remove() {
        return workList.pop();
    }

    public Square getNext() {
        return workList.pop();
    }

    public MazeSolverStack(Maze maze){
        super(maze);
        workList = new MyStack<Square>();
        add(maze.getStart());
        //solve();
    }
}
