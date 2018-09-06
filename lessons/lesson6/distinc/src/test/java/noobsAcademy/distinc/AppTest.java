package noobsAcademy.distinc;

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
     * A[0] = 2 A[1] = 1 A[2] = 1 A[3] = 2 A[4] = 3 A[5] = 1
     */
    public void testApp() {
	int[] A = { 2, 1, 1, 2, 3, 1 };
	assertEquals(3, Solution.solution(A));
    }

    public void testAppEmpty() {
	int[] A = {};
	assertEquals(0, Solution.solution(A));
    }
}
