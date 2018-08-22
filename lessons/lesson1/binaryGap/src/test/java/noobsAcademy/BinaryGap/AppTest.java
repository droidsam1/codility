package noobsAcademy.BinaryGap;

import junit.framework.TestCase;
import noobsAcademy.binaryGap.Solution;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {

    public void testExample() {
	assertEquals(5, Solution.solution(1041));
    }

    public void testOneDigitGap() {
	assertEquals(1, Solution.solution(5));
    }

    public void testNoZeros() {
	assertEquals(0, Solution.solution(15));
    }

    public void testNoGaps() {
	assertEquals(0, Solution.solution(32));
    }

    public void testOneDigit() {
	assertEquals(0, Solution.solution(1));
    }
}
