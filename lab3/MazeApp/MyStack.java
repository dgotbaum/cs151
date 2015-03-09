/**
 * Created by bleach678 on 2/26/15.
 */

import java.util.ArrayList;
import java.util.NoSuchElementException;


public class MyStack<T> implements StackADT{
    public ArrayList<T> x;

    public int size(){
        return x.size();
    }

    @SuppressWarnings("unchecked")
    public MyStack(){
        x = new ArrayList<T>();
    }

    public void push(Object element){
        x.add((T) element);
    }

    public T pop(){
        try{
            if(x.size()!=0){
                T z = x.remove(x.size() - 1);
                return z;
            }else{
                throw new NoSuchElementException();
            }
        } catch(NoSuchElementException e){
            System.out.println("You tried to remove an element, but the stack is empty");
        }
        return null;
    }

    public T top(){
        if (x.size()!=0){
            T toReturn = x.get(x.size()-1);
            return toReturn;
        }else {
            throw new NoSuchElementException();
        }
    }

    public boolean isEmpty(){
        return x.size() == 0;
    }

    public void clear(){
        x.clear();
    }

}
