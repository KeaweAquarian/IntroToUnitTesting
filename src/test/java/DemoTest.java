import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;


/**
 * The class containing your tests for the {@link Demo} class.  Make sure you
 * test all methods in this class (including both 
 * {@link Demo#main(String[])} and 
 * {@link Demo#isTriangle(double, double, double)}).
 */
public class DemoTest {

    @Test
    public void mainTrue() {

        String input = "2\n";
        input += "3\n";
        input += "4\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        System.setOut(new PrintStream(out));

        String[] args = {};
        Demo.main(args);

        //(expected) output
        String consoleOutput = "Enter side 1: " + System.getProperty("line.separator");
        consoleOutput += "Enter side 2: " + System.getProperty("line.separator");
        consoleOutput += "Enter side 3: " + System.getProperty("line.separator");
        consoleOutput += "This is a triangle." + System.getProperty("line.separator");

        assertEquals(consoleOutput, out.toString() );
    }

    @Test
    public void mainFalse() {

        String input = "1\n";
        input += "2\n";
        input += "3\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        System.setOut(new PrintStream(out));

        String[] args = {};
        Demo.main(args);

        //(expected) output
        String consoleOutput = "Enter side 1: " + System.getProperty("line.separator");
        consoleOutput += "Enter side 2: " + System.getProperty("line.separator");
        consoleOutput += "Enter side 3: " + System.getProperty("line.separator");
        consoleOutput += "This is not a triangle." + System.getProperty("line.separator");

        assertEquals(consoleOutput, out.toString() );
    }

    @Test(expected = java.util.InputMismatchException.class)
    public void testMainWithInvalidInput() {
        // Provide non-double input to the main method
        String input = "aaa\n";
        input += "2\n";
        input += "3\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        System.setOut(new PrintStream(out));

        String[] args = {};
        Demo.main(args);

    }

    @Test
    public void isTriangle() {

        assertTrue(Demo.isTriangle(4.0,2.0,3.0));
        assertTrue(Demo.isTriangle(5.0, 12.0, 13.0));
        assertTrue(Demo.isTriangle(8.0, 15.0, 17.0));
    }

    @Test
    public void isNotTriangle() {

        assertFalse(Demo.isTriangle(1.0,2.0,3.0));
        assertFalse(Demo.isTriangle(5.0, 10.0, 25.0));
        assertFalse(Demo.isTriangle(0, 0, 0));
    }

    @Test
    public void testNegativeSides() {
        assertFalse(Demo.isTriangle(-3.0, 4.0, 5.0));
        assertFalse(Demo.isTriangle(3.0, -4.0, 5.0));
        assertFalse(Demo.isTriangle(3.0, 4.0, -5.0));
    }

    @Test
    public void testZeroSides() {
        assertFalse(Demo.isTriangle(0.0, 4.0, 5.0));
        assertFalse(Demo.isTriangle(3.0, 0.0, 5.0));
        assertFalse(Demo.isTriangle(3.0, 4.0, 0.0));
    }


}
