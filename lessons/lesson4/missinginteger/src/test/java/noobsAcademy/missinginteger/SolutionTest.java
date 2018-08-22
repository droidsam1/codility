package noobsAcademy.missinginteger;

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

    public void testSolutionExample() {
	int[] example = new int[] { 1, 3, 6, 4, 1, 2 };
	assertEquals(5, Solution.solution(example));
    }

    public void testSolutionExample2() {
	int[] example = new int[] { 1, 2, 3 };
	assertEquals(4, Solution.solution(example));
    }

    public void testSolutionExample3() {
	int[] example = new int[] { -1, -3 };
	assertEquals(1, Solution.solution(example));
    }

    public void testSolutionOneElement() {
	int[] example = new int[] { 1 };
	assertEquals(2, Solution.solution(example));
    }

    public void testSolutionOneElement2() {
	int[] example = new int[] { 2 };
	assertEquals(1, Solution.solution(example));
    }

    public void testSolutioExample4() {
	int[] example = new int[] { 4, 5, 6, 2 };
	assertEquals(1, Solution.solution(example));
    }

    public void testSolutioExample5() {
	int[] example = new int[] { -500, 3, 5, 6, 2, 1 };
	assertEquals(4, Solution.solution(example));
    }

}
