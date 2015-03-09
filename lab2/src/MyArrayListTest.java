import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


import static org.junit.Assert.*;



/**
 * MyArrayListTest.java: Conducts tests for all methods, along with various efficiency checks.
 * I affirm that I have adhered to the honor code in this assignment.
 * @author James Capuder
 * on 2/19/15.
 */




public class MyArrayListTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testMyArrayList() throws Exception{
        MyArrayList<Integer> test = new MyArrayList<Integer>();
        ArrayList<Integer>   real = new ArrayList<Integer>();
        assertEquals("Size after construction", real.size(), test.size());
    }

    @Test
    public void testSize() throws Exception {
        MyArrayList<Integer> test = new MyArrayList<Integer>();
        ArrayList<Integer>   real = new ArrayList<Integer>();
        assertEquals( "Size after construction", real.size(), test.size());
        test.add(0,5);
        real.add(0,5);
        assertEquals( "Size after add", real.size(), test.size());
    }


    @Test(expected=IndexOutOfBoundsException.class)
    public void testForAddRightException() throws Exception {
        MyArrayList<Integer> test = new MyArrayList<Integer>();
        test.add(test.size()+1, 5);
    }


    @Ignore
    public void testAddE() throws FileNotFoundException {
        Scanner c = new Scanner(new File("test1.txt"));
        MyArrayList< String > test = new MyArrayList< String >();
        ArrayList< String > real = new ArrayList< String >();
        while (c.hasNextLine()) {
            String s = c.nextLine();
            test.add(s);
            real.add(s);
        }
        if (test.size() == real.size()) {
            for ( int i = 0; i < real.size(); i++ ) assertSame(test.get(i), real.get(i));
        }
    }

    @Ignore
    public void testAddIntEFront() throws FileNotFoundException {
        Scanner c = new Scanner(new File("test1.txt"));
        MyArrayList< String > test = new MyArrayList< String >();
        ArrayList< String > real = new ArrayList< String >();
        while (c.hasNextLine()) {
            String s = c.nextLine();
            test.add(0, s);
            real.add(0, s);
        }
        //System.out.println(test);
        //System.out.println(real);
        if (test.size() == real.size()) {
            for ( int i = 0; i < real.size(); i++ ) assertSame(test.get(i), real.get(i));
        }
    }

    @Ignore
    public void testAddIntEBack() throws FileNotFoundException {
        Scanner c = new Scanner(new File("test1.txt"));
        MyArrayList< String > test = new MyArrayList< String >();
        ArrayList< String > real = new ArrayList< String >();
        while (c.hasNextLine()) {
            String s = c.nextLine();
            test.add((test.size() / 2), s);
            real.add((real.size() / 2), s);
        }
        //System.out.println(test);
        //System.out.println(real);
        if (test.size() == real.size()) {
            for ( int i = 0; i < real.size(); i++ ) assertSame(test.get(i), real.get(i));
        }
    }

    @Ignore
    public void testGet() throws Exception {
        MyArrayList< Integer > test = new MyArrayList();
        ArrayList< Integer > real = new ArrayList< Integer >();
        test.add(1);
        real.add(1);
        test.add(2);
        real.add(2);
        test.add(0, 0);
        real.add(0, 0);
        assertEquals("Size after construction: ", test.get(1), real.get(1));
    }


    @Test (expected=IndexOutOfBoundsException.class )
    public void testIndexOutofBoundsGet() {
        MyArrayList<Integer> test = new MyArrayList<Integer>();
        test.add(1); //index 0
        test.add(2); //index 1
        test.get(2); //size +1
    }


    @Test (expected=IndexOutOfBoundsException.class )
    public void testIndexOutofBoundsGet2() {
        MyArrayList<Integer> test = new MyArrayList<Integer>();
        test.add(1); //index 0
        test.add(2); //index 1
        test.get(-1); //size -1
    }


    @Ignore
    public void testRemove() throws FileNotFoundException {
        Scanner c = new Scanner(new File("test1.txt"));
        MyArrayList< String > test = new MyArrayList< String >();
        MyArrayList< String > second = new MyArrayList< String >();
        ArrayList< String > real = new ArrayList< String >();
        ArrayList< String > realTwo = new ArrayList< String >();

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

    @Ignore
    public void testSet() throws FileNotFoundException {
        Scanner c = new Scanner(new File("test1.txt"));
        MyArrayList< String > test = new MyArrayList< String >();
        ArrayList< String > real = new ArrayList< String >();
        ArrayList< String > realTwo = real;
        MyArrayList< String > testTwo = test;

        while ( c.hasNext() ) {
            String s = c.next();
            test.add(s);
            real.add(s);
        }
        for ( int i = 0; i < test.size(); i++ ) {
            String q = test.get(test.size() - i - 1);
            String r = real.get(real.size() - i - 1);
            testTwo.set(i, q);
            realTwo.set(i, r);
        }

        for ( int i = 0; i < testTwo.size(); i++ ) assertSame("String Same?", real.get(i), testTwo.get(i));
    }

    @Ignore
    public void testAdd() throws Exception {
        MyArrayList< Integer > test = new MyArrayList();
        ArrayList< Integer > real = new ArrayList< Integer >();
        test.add(1);
        real.add(1);
        test.add(2);
        real.add(2);
        test.add(0, 0);
        real.add(0, 0);
        assertEquals("Size after construction: ", test.size(), real.size());
    }

    @Ignore
    public void isEmptyTest() {
        MyArrayList< String > test = new MyArrayList< String >();
        assertTrue(test.isEmpty());
    }

    @Ignore
    public void clearTest() throws FileNotFoundException {
        Scanner c = new Scanner(new File("test1.txt"));
        MyArrayList<String> test = new MyArrayList<String>();
        ArrayList<String> real = new ArrayList<String>();
        while (c.hasNext()) {
            String s = c.next();
            test.add(s);
            real.add(s);
        }
        test.clear();
        real.clear();
        assertEquals(true, test.isEmpty());
        assertEquals(true, real.isEmpty());

    }

    @Ignore
    public void testAddEfficiency() throws InterruptedException {
        int counter = 0;
        MyArrayList< Integer > test = new MyArrayList<Integer>();
        for ( int i = 0; i < 1000000; i++ ) {
            int toAdd = test.size();
            //test.add(0, toAdd);
            test.add(toAdd);
            counter++;
            if (counter==10000) {
                System.out.println(test.size());
                counter = 0;
            }
        }
    }

    @Ignore
    public void testRemoveEfficiency()  throws InterruptedException {
        MyArrayList< Integer > test = new MyArrayList<Integer>();
        for ( int i = 0; i < 1000000; i++ ) {
            test.add(i);
        }
        int counter = 0;
        for ( int j = 999999; j >= 0; j-- ) {
            test.remove(j);
            counter++;
            if( counter == 10000 ){
                System.out.println(test.size());
                counter = 0;
            }
        }
        System.out.println(test.size());
    }

    @Test
    public void testMemory() {
        MyArrayList<Integer> test = new MyArrayList<Integer>();
        for ( int i = 0;i<100000000; i++ ) {
            while (9 < i ) i/=10;
            if ( Math.abs(i) == 1 ) {
                test.add(i);
                if( (i%10000) == 0) {
                    System.out.println(i);
                }
            }
        }
    }


}