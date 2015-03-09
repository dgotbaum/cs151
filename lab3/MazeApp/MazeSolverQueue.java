/**
 * @author James Capuder and Jack Benson
 */
public class MazeSolverQueue extends MazeSolver{
    private MyQueue<Square> workList;


    public void makeEmpty() {
        workList = new MyQueue<Square>();
    }

    public boolean isEmpty() {
        return workList.isEmpty();
    }

    public void add(Square sq) {
        workList.enqueue(sq);
    }

    public Square remove() {
        return workList.dequeue();
    }

    public Square getNext() {
        return workList.dequeue();
    }

    public MazeSolverQueue(Maze maze){
        super(maze);
        workList = new MyQueue<Square>();
        add(maze.getStart());
        //solve();
    }
}
