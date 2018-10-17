package noobsAcademy.triangle;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName
     *            name of the test case
     */
    public AppTest(String testName) {
	super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
	return new TestSuite(AppTest.class);
    }

    /**
     * For example, consider array A such that:
     * 
     * A[0] = 10 A[1] = 2 A[2] = 5 A[3] = 1 A[4] = 8 A[5] = 20
     * 
     * Triplet (0, 2, 4) is triangular.
     */
    public void testApp() {

	int input[] = new int[] { 10, 2, 5, 1, 8, 20 };
	assertEquals(1, Triangle.solution(input));
    }

    public void testSinSolucion() {

	int input[] = new int[] { 10, 50, 5, 1 };
	assertEquals(0, Triangle.solution(input));
    }

    public void testNotEnoughtNumbers() {

	int input[] = new int[] { 10, 50 };
	assertEquals(0, Triangle.solution(input));
    }

    public void testArithOverflow() {

	int input[] = new int[] { Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE };
	assertEquals(1, Triangle.solution(input));
    }

}
