package noobsAcademy.numberofdiscintersections;

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
     * * A[0] = 1 A[1] = 5 A[2] = 2 A[3] = 1 A[4] = 4 A[5] = 0
     */
    public void testApp() {
	int input[] = new int[] { 1, 5, 2, 1, 4, 0 };
	assertEquals(11, Solution.solution(input));
    }

    /**
     * [1, 1, 1]
     */
    public void testAppTripleOne() {
	int input[] = new int[] { 1, 1, 1 };
	assertEquals(3, Solution.solution(input));
    }

}
