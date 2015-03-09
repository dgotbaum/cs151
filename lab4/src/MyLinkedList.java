/**
 * @author James Capuder and Jack Benson
 */

import java.util.*;

public class MyLinkedList<T> extends AbstractList<T>  {

    private Node head;
    private Node tail;
    private int sizeCounter;

    protected class Node {
        T data;
        Node next;
        Node prev;

        public Node(){
            data = null;
            next = null;
            prev = null;
        }

        public Node(T initData){
            data = initData;
            next = null;
            prev = null;
        }

        public Node(T initData, Node initPrev, Node initNext){
            data = initData;
            prev = initPrev;
            next = initNext;
            initPrev.next = next.prev;
            initNext.prev = prev.next;
        }
    }

    protected class MyLinkedListIterator implements ListIterator<T> {
        private int index;
        public MyLinkedListIterator() {
            index = 0;
        }
        public void add(T item) {
            MyLinkedList.this.add(item);
            //index++;

        }

        public boolean hasNext() {
            if (index == 0 && MyLinkedList.this.size() > 0)
                return true;
            else if (index<MyLinkedList.this.size()-1)
                return true;
            else
                return false;

        }

        @Override
        public boolean hasPrevious() {
            return (index > 0);
        }

        @Override
        public T next() throws NoSuchElementException{
            if (hasNext()) {
                return MyLinkedList.this.get(index++);
            }
            else
                throw new NoSuchElementException();


        }

        public int nextIndex()  {
            if (index == MyLinkedList.this.size() - 1)
                return MyLinkedList.this.size() ;
            else
                return index + 1;
        }

        @Override
        public T previous() throws NoSuchElementException{
            if (hasPrevious()) {
                return MyLinkedList.this.get(index--);
            }
            else
                throw new NoSuchElementException();

        }

        @Override
        public int previousIndex() {
            return index - 1;
        }

        @Override
        public void remove() {

            MyLinkedList.this.remove(index);

        }

        @Override
        public void set(T item) {
            MyLinkedList.this.set(index, item);

        }
        public T get() {
            return MyLinkedList.this.get(index);
        }

    }

    @SuppressWarnings("unchecked")
    public MyLinkedList(){
        head = new Node();
        tail = new Node();
        head.prev = null;
        tail.next = null;
        tail.prev=head;
        head.next=tail;
        sizeCounter = 0;
    }

    private Node getNth(int index){
        int x = 0;
        Node iterate = head;
        Node toReturn = new Node();
        while (x<index){
            toReturn = iterate.next;
        }
        return toReturn;
    }
    public Iterator<T> getIterator() {
        return new MyLinkedListIterator();
    }
    public boolean add(T data){
//        sizeCounter++;
//        Node x = new Node(data);
//        if (size() == 0){
//            head.next = x;
//            tail.prev = x;
//            x.next = tail;
//            x.prev = head;
//        } else{
//            tail.next = x;
//            x.prev = tail;
//            tail = x;
//        }
//        return true;
        this.add(sizeCounter, data);
        return true;
    }

    public void add(int index, T data){
        if (index > this.size()) throw new IndexOutOfBoundsException("Your index was greater than the number of nodes.");
        if (data == null) throw new NullPointerException("You tried to make a node with null data. Can't do that (;_;)");
        Node x = new Node(data);
        if (sizeCounter == 0) {
            head.next = x;
            tail.prev = x;
            x.next = tail;
            x.prev = head;
        }
        else {
            int i = 0;
            Node iterate = head.next;
            while (i < index) {
                //System.out.printf("Index: %d ; Data at Index: %d \n", i, iterate.data);
                iterate = iterate.next;
                i++;
            }
            x.next = iterate;
            x.prev = iterate.prev;
            iterate.prev.next = x;
            iterate.prev = x;
        }
        sizeCounter++;
    }

    public T get(int i){
        if (i>size()-1) throw new IndexOutOfBoundsException("Whoops, you tried to get contents of a node that does not exist!");
        int j = 0;
        Node toGet = head.next;
        while (j<i){
            toGet = toGet.next;
            j++;
        }
        return toGet.data;
    }

    public T set(int i, T data){
        if (i > size()-1) throw new IndexOutOfBoundsException("Your index was greater than the number of nodes.");
        if (data == null) throw new NullPointerException("You tried to make a node with null data. Can't do that (;_;)");
        int j =0;
        Node toSet = head.next;
        while (j<i){
            toSet = toSet.next;
            j++;
        }
        T temp = toSet.data;
        toSet.data = data;
        return temp;
    }

    public T remove(int i){
        if (i > size()-1) throw new IndexOutOfBoundsException("Your index was greater than the number of nodes.");
        sizeCounter--;
        int j = 0;
        Node toRemove = head.next;
        while (j<i){
            toRemove = toRemove.next;
            j++;
        }
        toRemove.prev.next = toRemove.next;
        toRemove.next.prev = toRemove.prev;
        return toRemove.data;
    }

    public void clear(){
        for (int i=0; i<size()-1; i++){
            remove(i);
        }
        sizeCounter=0;
    }

    public boolean isEmpty(){
        if (size()==0){
            return true;
        }  else{
            return false;
        }
    }

    public int size(){
        return sizeCounter;
    }

    @Override
    public MyLinkedListIterator listIterator(){
        MyLinkedListIterator illiterator = new MyLinkedListIterator();
        return illiterator;
    }

    @Override
    public MyLinkedListIterator iterator(){
        MyLinkedListIterator illiterator = new MyLinkedListIterator();
        return illiterator;
    }

    public Node getHead(){
        return head;
    }



}

