/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package euromillions;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.IntStream;

import org.junit.jupiter.api.*;

import sets.SetOfNaturals;

/**
 * @author ico0
 */
public class DipTest {

    private Dip instance;


    public DipTest() {
    }

    @BeforeEach
    public void setUp() {
        instance = new Dip(new int[]{10, 20, 30, 40, 50}, new int[]{1, 2});
    }

    @AfterEach
    public void tearDown() {
        instance = null;
    }


    @Test
    public void testConstructorFromBadArrays() {
        // todo: instantiate a dip passing valid or invalid arrays
        //wrong number of stars
        assertThrows(IllegalArgumentException.class, ()->{new Dip(new int[]{10, 20, 30, 40, 50}, new int[]{1, 2, 3});});

        // wrong number of numbers
        assertThrows(IllegalArgumentException.class, ()->{new Dip(new int[]{10, 20, 30, 40}, new int[]{1, 2});});
    }

    @Test
    public void testFormat() {
        // note: correct the implementation of the format(), not the test...
        String result = instance.format();
        assertEquals("N[ 10 20 30 40 50] S[  1  2]", result, "format as string: formatted string not as expected. ");
    }

    @DisplayName("Check if we can have 12 stars")
    @Test
    public void testNumberStars(){
        SetOfNaturals allStars = new SetOfNaturals();
        allStars.add(IntStream.rangeClosed(1,12).boxed().mapToInt(i->i).toArray());
        instance.getStarsColl().forEach(integer->assertTrue(allStars.contains(integer)));
    }
}
