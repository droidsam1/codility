package noobsAcademy.missinginteger;

import java.util.Arrays;

/**
 * Write a function:
 * 
 * that, given an array A of N integers, returns the smallest positive integer
 * (greater than 0) that does not occur in A.
 *
 * Assume that:
 * 
 * N is an integer within the range [1..100,000]; each element of array A is an
 * integer within the range [−1,000,000..1,000,000].
 */
public class Solution {
    public static int solution(int[] A) {
	int smallestPositiveInt = 1;
	Arrays.sort(A);
	if (A[0] != 1 && A[0] > 0) {
	    return smallestPositiveInt;
	} else if (A[0] == 1 && A.length == 1) {
	    return 2;
	}

	for (int i = 1; i < A.length - 1; i++) {
	    if (A[i] > 1) {
		int nextConsecutiveNumber = A[i + 1];
		if ((nextConsecutiveNumber - A[i]) > 1) {
		    return A[i] + 1;
		} else {
		    if (nextConsecutiveNumber >= smallestPositiveInt) {
			smallestPositiveInt = nextConsecutiveNumber + 1;
		    }
		}
	    }
	}
	return smallestPositiveInt;
    }
}