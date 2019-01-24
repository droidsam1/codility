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
     * @param testName name of the test case
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


    public void testApp() {
        int[] A = new int[]{1, 5, 2, 1, 4, 0};
        assertEquals(11, Solution.solution(A));
    }


    public void testApp2() {
        int[] A = new int[]{1, 2147483647, 0};
        assertEquals(2, Solution.solution(A));
    }


    public void testApp3() {
        int[] A = new int[]{0, 1, 2, 3, 0};
        assertEquals(8, SolutionI.solution(A));
    }

}
