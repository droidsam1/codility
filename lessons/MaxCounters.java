/**
 * 
 */
package testing;

public class MaxCounters {

    /*
     * A[0] = 3 A[1] = 4 A[2] = 4 A[3] = 6 A[4] = 1 A[5] = 4 A[6] = 4
     * 
     * 
     */

    public static void main(String[] args) {
	int[] test = { 3, 4, 4, 6, 1, 4, 4 };
	int[] test2 = { 1, 6, 6, 6, 6, 6, 6 };

	int[] solution = solution(5, test);
	int[] solution2 = solution(5, test2);

	System.out.print("Solution: [");
	for (int s : solution2) {
	    System.out.print(s + ", ");
	}
	System.out.println("]");

    }

    public static int[] solution(int N, int[] A) {
	// write your code in Java SE 8
	int maxCounters = N + 1;
	int[] result = new int[N];
	int currentMax = 0;
	int currentBase = 0;

	for (int i = 0; i < A.length; i++) {
	    if (A[i] == maxCounters) {
		result = null;
		currentBase += currentMax;
		currentMax = 0;
	    } else {
		int index = A[i] - 1;
		result = createResultArrayIfNull(result, N);
		result[index] = result[index] + 1;
		if (result[index] > currentMax) {
		    currentMax = result[index];
		}
	    }

	}
	return buildFinalArray(result, N, currentBase);

    }

    private static int[] buildFinalArray(int[] result, int resultSize, int currentBase) {
	result = createResultArrayIfNull(result, resultSize);
	for (int i = 0; i < result.length; i++) {
	    result[i] = result[i] + currentBase;
	}
	return result;
    }

    /**
     * This is an post-optimization that made me pass the last test. Due to the
     * slowest operation in Java is the creation of an object, I am trying to
     * recreate the array only when necessary
     */
    private static int[] createResultArrayIfNull(int[] result, int size) {
	if (result == null) {
	    result = new int[size];
	}
	return result;
    }

}
