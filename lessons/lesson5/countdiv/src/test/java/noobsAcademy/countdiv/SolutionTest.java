package noobsAcademy.countdiv;

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

    public void testExample() {
	assertEquals(3, Solution.solution(6, 11, 2));
    }

    public void testExample2() {
	assertEquals(0, Solution.solution(10, 10, 7));
    }

    public void testExample3() {
	assertEquals(2, Solution.solution(11, 14, 2));
    }

    public void testExample4() {
	assertEquals(1, Solution.solution(0, 0, 11));
    }

    public void testExample5() {
	assertEquals(1, Solution.solution(1, 1, 1));
    }

    public void testExample6() {
	assertEquals(2000000001, Solution.solution(0, 2000000000, 1));
    }

    public void testExampleBig() {
	long start = System.nanoTime();
	assertEquals(2000000001, Solution.solution(0, 2000000000, 1));
	long end = System.nanoTime();
	assertTrue("Time out", (end - start) < 10000);
    }

}
