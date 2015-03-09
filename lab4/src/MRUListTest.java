import org.junit.Test;

import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

import static org.junit.Assert.*;

public class MRUListTest {

    @Test
    public void testContains() throws Exception {
        Scanner c = new Scanner(new File("small-wordlist.txt"));
        MRUList<String> test = new MRUList<String>();
        while (c.hasNext()) {
            String S = c.next();
            test.add(S);
        }
        System.out.println(test);
        test.contains("Mr");
        System.out.println(test);
        //String f = "SFC";
        assertEquals("Hopleh", test.get(0), "Mr");
    }

    @Test
    public void testAdd() throws Exception {

    }

    @Test
    public void testAdd1() throws Exception {

    }
}