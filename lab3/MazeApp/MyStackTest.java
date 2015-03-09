import org.junit.Test;

import static org.junit.Assert.*;
import java.util.Stack;

public class MyStackTest {

    @Test
    public void testSize() throws Exception {
        MyStack testStack = new MyStack<Square>();
        Stack realstack = new Stack();
        assertEquals("Sizes", testStack.size(), realstack.size());
    }

    @Test
    public void testPush() throws Exception {
        MyStack testStack = new MyStack<Square>();
        Stack realstack = new Stack<Square>();
        Square testSquare = new Square(3, 0, 0);
        testStack.push(testSquare);
        realstack.push(testSquare);
        assertEquals("Size n stuff", testStack.size(), realstack.size());
    }

    @Test
    public void testPop() throws Exception {
        MyStack testStack = new MyStack<Square>();
        Stack realstack = new Stack();
        Square testSquare = new Square(3, 0, 0);
        testStack.push(testSquare);
        realstack.push(testSquare);
        realstack.pop();
        testStack.pop();
        assertEquals("Size n stuff", testStack.size(), realstack.size());
    }

    @Test
    public void testTop() throws Exception {

    }

    @Test
    public void testIsEmpty() throws Exception {

    }

    @Test
    public void testClear() throws Exception {

    }
}