package lab1.lab1_1;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class TqsStack<T> {
    private LinkedList<T> stack;
    private int maxBound = -1;

    public TqsStack(){
        this.stack = new LinkedList<T>();
    }

    public TqsStack(int i){
        this.stack = new LinkedList<T>();
        this.maxBound = i;
    }

    // add an item on the top
    public void push(T x){
        if (maxBound==-1){
            stack.push(x);
        } else{
            if (this.size()<this.maxBound){
                stack.push(x);
            } else{
                throw new IllegalStateException();
            }
        }
        
    }

    // remove the item at the top
    public T pop() throws NoSuchElementException{
        return (T) stack.pop();
    }

    // return the item at the top (without removing it)
    public T peek() throws NoSuchElementException{
        if (stack.peekFirst()!=null){
            return (T) stack.peekFirst();
        }
        throw new NoSuchElementException();
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