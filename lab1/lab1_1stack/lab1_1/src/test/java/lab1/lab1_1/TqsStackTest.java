package lab1.lab1_1;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}