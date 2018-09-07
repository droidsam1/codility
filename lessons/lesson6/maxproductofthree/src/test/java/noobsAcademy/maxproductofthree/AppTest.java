package noobsAcademy.maxproductofthree;

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

    public void testExample() {
	int[] A = { -3, 1, 2, -2, 5, 6 };
	assertEquals(60, Solution.solution(A));
    }

    public void testExample2() {
	int[] A = { -5, 5, -5, 4 };
	assertEquals(125, Solution.solution(A));
    }

    public void testExample3() {
	int[] A = { 4, 5, 1, 0 };
	assertEquals(20, Solution.solution(A));
    }

    public void testExampleNegative() {
	int[] A = { -10, -2, -4 };
	assertEquals(-80, Solution.solution(A));
    }

    public void testExampleNegative2() {
	int[] A = { -5, -6, -4, -7, -10 };
	assertEquals(-120, Solution.solution(A));
    }

}
