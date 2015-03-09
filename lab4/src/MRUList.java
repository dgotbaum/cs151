/**
 * MRUlist implementation
 * We affirm that we have adhered to the honor code in this assigment
 * @author James Capuder and Jack Benson
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MRUList<T> extends MyLinkedList<T> {

    public boolean contains(Object o) {
        MyLinkedListIterator it = super.iterator();
        while (it.hasNext()){
            T temp;
            temp = it.next();
            //System.out.println("First Temp" + temp);
            if (o.equals(temp)) {
                super.remove(it.previousIndex());
                add(0, temp);
                return true;
            }
        }
	    return false;
    }
    
    public boolean add(T x) {
        super.add(0, x);
	return true;
    }

    public void add(int index, T x) {
       super.add(0, x);
    }
    
}
