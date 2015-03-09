import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

import static org.junit.Assert.*;

public class MyLinkedListTest extends MyLinkedList {

    @Test
    public void testMyLinkedList(){
        MyLinkedList<Integer> test = new MyLinkedListTest();
        LinkedList<Integer> real = new LinkedList<Integer>();
        assertEquals("Size After sexpected", real.size(), test.size());
    }

    @Test
    public void testAdd() throws Exception {
        MyLinkedList< Integer > test = new MyLinkedList<Integer>();
        LinkedList< Integer > real = new LinkedList<Integer>();
        test.add(1);
        real.add(1);
        test.add(0,2);
        real.add(0,2);
        assertEquals("Size after construction: ", test.size(), real.size());
    }

    @Test
    public void testAdd1() throws Exception {

    }

    @Test
    public void testGet() throws Exception {
        MyLinkedList< Integer > test = new MyLinkedList<Integer>();
        LinkedList< Integer > real = new LinkedList<Integer>();
        test.add(1);
        real.add(1);
        test.add(2);
        real.add(2);
        test.add(0);
        real.add(0);
        assertEquals("Test Get: ", real.get(2), test.get(2));
    }

    @Ignore
    public void testSet() throws Exception {
        Scanner c = new Scanner(new File("small-wordlist.txt"));
        MyLinkedList< String > test = new MyLinkedList<String>();
        LinkedList< String > real = new LinkedList<String>();
        MyLinkedList< String > test2 = new MyLinkedList<String>();
        LinkedList<String> real2 = new LinkedList<String>();

        while ( c.hasNext() ) {
            String s = c.next();
            test.add(s);
            real.add(s);
            test2.add(s);
            real2.add(s);
        }
        for ( int i = 0; i < test.size(); i++ ) {
            //System.out.println(i);
            String q = test.get(test.size() - i - 1);
            String r = real.get(real.size() - i - 1);
            //System.out.println(q);
            test2.set(i, q);
            real2.set(i, r);
        }

        for ( int i = 0; i < test2.size(); i++ ) assertSame("String Same?", real2.get(i), test2.get(i));

    }

    @Test
    public void testRemove() throws Exception {
        Scanner c = new Scanner(new File("small-wordlist.txt"));
        MyLinkedList< String > test = new MyLinkedList< String >();
        MyLinkedList< String > second = new MyLinkedList< String >();
        LinkedList< String > real = new LinkedList< String >();
        LinkedList< String > realTwo = new LinkedList< String >();

        while ( c.hasNext() ) {
            String s = c.next();
            test.add(s);
            real.add(s);
        }
        for ( int i = 0; i < test.size(); i++ ) {
            if ( i % 2 == 0 ) {
                second.add(test.remove(i));
                realTwo.add(real.remove(i));
            }
        }
        for ( int i = 0; i < second.size(); i++ ) assertSame("String Same?", realTwo.get(i), second.get(i));
        System.out.println(test);
        System.out.println(second);
        System.out.println(real);
        System.out.println(realTwo);

    }

    @Test
    public void testClear() throws Exception {
        Scanner c = new Scanner(new File("small-wordlist.txt"));
        MyLinkedList< String > test = new MyLinkedList< String >();
        LinkedList< String > real = new LinkedList< String >();
        while ( c.hasNext() ) {
            String s = c.next();
            test.add(s);
            real.add(s);
        }
        System.out.println(test);
        test.clear();
        real.clear();

        assertEquals(true, test.isEmpty());
        assertEquals(true, real.isEmpty());
    }

    @Test
    public void testIsEmpty() throws Exception {

    }

    @Test
    public void testSize(){
        MyLinkedList< Integer > test = new MyLinkedList<Integer>();
        LinkedList< Integer > real = new LinkedList<Integer>();
        test.add(5);
        real.add(5);
        assertEquals( "Size after add", real.size(), test.size());
    }



}