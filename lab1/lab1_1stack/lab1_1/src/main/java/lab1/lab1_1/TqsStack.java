package lab1.lab1_1;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class TqsStack<T> {
    private LinkedList<T> stack;

    public TqsStack(){
        this.stack = new LinkedList<T>();
    }

    // add an item on the top
    public void push(T x){

    }

    // remove the item at the top
    public void pop(){
        
    }

    // return the item at the top (without removing it)
    public T peek(){
        return "";
    }

    // return the number of items in the stack
    public int size(){
        return stack.size();
    }

    // return whether the stack has no items
    public boolean isEmpty(){
        return stack.isEmpty();
    }
}