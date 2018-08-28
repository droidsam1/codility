package noobsAcademy.genomicrangequery;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

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

    // public void testExampleOne() {
    // String S = "CAGCCTA";
    // int[] P = new int[] { 2, 5, 0 };
    // int[] Q = new int[] { 4, 5, 6 };
    //
    // assertEquals(new int[] { 2, 4, 1 }, Solution.solution(S, P, Q));
    // }

    public void testExampleThree() {
	String S = "AC";
	int[] P = new int[] { 0, 0, 1 };
	int[] Q = new int[] { 0, 1, 1 };

	int[] expectedSolution = new int[] { 1, 1, 2 };
	int[] actualSolution = Solution.solution(S, P, Q);

	for (int i = 0; i < expectedSolution.length; i++) {
	    assertEquals(expectedSolution[i], actualSolution[i]);
	}
    }

    public void testExampleTwo() {
	String S = "CAGCCTA";
	int[] P = new int[] { 2, 5, 0 };
	int[] Q = new int[] { 4, 5, 6 };

	int[] expectedSolution = new int[] { 2, 4, 1 };
	int[] actualSolution = Solution.solution(S, P, Q);

	for (int i = 0; i < expectedSolution.length; i++) {
	    assertEquals(expectedSolution[i], actualSolution[i]);
	}
    }

    public void testExampleOne() {
	String S = "CAGCCTA";
	int[] P = new int[] { 2 };
	int[] Q = new int[] { 4 };

	int[] expectedSolution = new int[] { 2 };
	int[] actualSolution = Solution.solution(S, P, Q);

	for (int i = 0; i < expectedSolution.length; i++) {
	    assertEquals(expectedSolution[i], actualSolution[i]);
	}
    }

    public void testExampleOneElementString() {
	String S = "C";
	int[] P = new int[] { 0 };
	int[] Q = new int[] { 0 };

	int[] expectedSolution = new int[] { 2 };
	int[] actualSolution = Solution.solution(S, P, Q);

	for (int i = 0; i < expectedSolution.length; i++) {
	    assertEquals(expectedSolution[i], actualSolution[i]);
	}
    }

    public void testExampleBig() {

	String S;
	StringBuilder sb = new StringBuilder();
	for (int i = 0; i < 100000; i++) {
	    sb.append("G");
	}

	S = sb.toString();

	List<Integer> p = new ArrayList<Integer>();
	List<Integer> q = new ArrayList<Integer>();

	for (int i = 0; i < 10000; i++) {
	    p.add(0);
	    q.add(100000 - 1);
	}

	int[] P = ArrayUtils.toPrimitive(p.toArray(new Integer[q.size()]));
	int[] Q = ArrayUtils.toPrimitive(q.toArray(new Integer[q.size()]));

	// int[] expectedSolution = new int[] { 3, 3 };
	long start = System.nanoTime();
	int[] actualSolution = Solution.solution(S, P, Q);
	long end = System.nanoTime();

	long startRef = System.nanoTime();
	char[] charArray = S.toCharArray();
	char c;
	for (int i = 0; i < S.length(); i++) {
	    c = charArray[i];
	}
	int n;
	for (int i = 0; i < P.length; i++) {
	    n = P[i];
	}
	long endRef = System.nanoTime();

	// for (int i = 0; i < expectedSolution.length; i++) {
	// assertEquals(expectedSolution[i], actualSolution[i]);
	// }
	assertTrue("TIMEOUT ERROR " + (end - start) + "ref time" + 20 * (endRef - startRef),
		(end - start) < 20 * (endRef - startRef));
    }
}
