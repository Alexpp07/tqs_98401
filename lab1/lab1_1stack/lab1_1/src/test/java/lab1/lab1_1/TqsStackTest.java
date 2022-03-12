package lab1.lab1_1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

public class TqsStackTest {
    private TqsStack<String> stackTest;

    @BeforeEach
    void set_up(){
        stackTest = new TqsStack<String>();
    }

    @DisplayName("checking if a stack is empty")
    @Test
    public void isEmpty(){
        assertTrue(stackTest.isEmpty());
    }

    @DisplayName("size zero on construction")
    @Test
    public void sizeZeroOnConstruction(){
        assertEquals(0, stackTest.size());
    }

    @DisplayName("after n pushes, stack is not empty and size equals n")
    @Test
    public void afterPushes(){
        stackTest.push("Alex");
        stackTest.push("João");
        stackTest.push("Rui");
        assertFalse(stackTest.isEmpty());
        assertEquals(3, stackTest.size());
    }

    @DisplayName("after push n, pops n")
    @Test
    public void popAfterPush(){
        stackTest.push("PUSH-POP");
        assertEquals("PUSH-POP", stackTest.pop());
    }

    @DisplayName("one pushes x then peeks, the value returned is x, but the size stays the same")
    @Test
    public void peekAfterPush(){
        stackTest.push("PUSH-PEEK");
        int size = stackTest.size();
        assertEquals("PUSH-PEEK", stackTest.peek());
        assertEquals(size, stackTest.size());
    }

    
    @DisplayName("if the size is n, then after n pops, the stack is empty and has a size 0")
    @Test
    public void popSize(){
        int size = stackTest.size();
        for (int i = 0; i < size; i++){
            stackTest.pop();
        }
        assertTrue(stackTest.isEmpty());
        assertEquals(0, stackTest.size());
    }

    @DisplayName("popping from an empty stack does throw a NoSuchElementException")
    @Test
    public void popEmpty() {
        assertThrows( NoSuchElementException.class,()->{stackTest.pop();});
    }

    @DisplayName("peeking into an empty stack does throw a NoSuchElementException")
    @Test
    public void peekEmpty(){
        assertThrows(NoSuchElementException.class,()->{stackTest.peek();});
    }

    @DisplayName("push into a full bounded stack")
    @Test
    public void pushBounded() {

        TqsStack<Integer> newStack = new TqsStack<Integer>(3);

        newStack.push(1);
        newStack.push(2);
        newStack.push(3);

        assertThrows(IllegalStateException.class, () -> {
            newStack.push(999);
        });

    }
}