package noobsAcademy.passingCars;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class SolutionTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName
     *            name of the test case
     */
    public SolutionTest(String testName) {
	super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
	return new TestSuite(SolutionTest.class);
    }

    /**
     * A[0] = 0 A[1] = 1 A[2] = 0 A[3] = 1 A[4] = 1 <br>
     * We have five pairs of passing cars: <br>
     * (0, 1), (0, 3), (0, 4), (2, 3), (2,4).
     * 
     * 
     */
    public void testApp() {
	int[] A = new int[] { 0, 1, 0, 1, 1 };
	assertEquals(5, Solution.solution(A));
    }
}
