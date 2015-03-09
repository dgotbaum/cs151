

import java.util.AbstractList;

/**
 * MyArrayList.java: An implementation of the ArrayList data structure
 * I affirm that I have adhered to the honor code in this assignment.
 * @author James Capuder
 * on 2/19/15.
 */




public class MyArrayList<AnyType> extends AbstractList<AnyType> {
    private int size;
    private AnyType[] data;


    /**
     * Constructs an array list
     * @param startSize
     */

    @SuppressWarnings("unchecked")
    public MyArrayList(int startSize){
        int x = 1;
        while (x<startSize){
            x*=2;
        }
        data = (AnyType [])new Object[x];
    }


    /**
     * Construcuts an array list of length 2
     */
    public MyArrayList(){
        this(2);
    }

    /**
     * Doubles the size of the array list
     */

    private void resize(){
        int x = data.length;
        AnyType[] newData = (AnyType []) new Object[2*x];
        for (int i=0; i<data.length; i++){
            newData[i] = data[i];
        }
        data = newData;
    }


    /**
     * Returns the number of elements in the array list
     * @return
     */
    public int size(){
        int counter = 0;
        for (int z=0; z<data.length;z++){
            if (data[z] != null){
                counter++;
            }
        }
        return counter;
    }

    /**
     * Adds an element to the specified index, all other elements are shifted right to accommodate
     * @param index
     * @param element
     */
    public void add(int index, AnyType element){
        if (index > size()){
            throw new IndexOutOfBoundsException("Sorry, the highest index you can enter is the first unused index");
        }
        else{
            if (data.length == size()){resize();}
            int j = size();
            while (j>index){
               AnyType temp = data[j-1];
                data[j] = temp;
                j--;
            }
            data[index] = element;
        }
    }

    /**
     * Adds an element to the end of the array list
     * @param element
     * @return
     */

    public boolean add(AnyType element){
        if (data.length==size()){resize();}
        add(size(), element);
        return true;
    }


    /**
     * Returns the value at the specified index
     * @param index
     * @return
     */
    public AnyType get(int index){
        if (index > size()-1){
            throw new IndexOutOfBoundsException("Sorry, the index you entered is out of the allowed range.");
        } else{
            return data[index];
        }
    }


    /**
     * Sets the value at an index to an element, and returns the one that was previously there
     * @param index
     * @param element
     * @return
     */
    public AnyType set(int index, AnyType element) {
        if (index > size()-1) {
            throw new IndexOutOfBoundsException("Sorry, the index you entered is out of the allowed range.");
        } else{
            AnyType temp = data[index];
            data[index] = element;
            return temp;
        }
    }


    /**
     * Removes the value at an index and returns it.
     * @param index
     * @return
     */
    public AnyType remove(int index){
        if (index > size()-1) {
            throw new IndexOutOfBoundsException("Sorry, the index you entered is out of the allowed range.");
        } else {
            AnyType returnValue = data[index];
            while (size()>index){
                data[index]=data[index+1];
                index++;
            }
            return returnValue;
        }
    }

    /**
     * A method to check if the array list is empty. Returns true or false
     * @return
     */
    public boolean isEmpty(){
        if (0!=size()){
            return false;
        } else{
            return true;
        }
    }

    /**
     * Sets all values to null.
     */
    public void clear(){
        for (int indices=0; indices<data.length; indices++){
            data[indices] = null;
        }
    }



}
