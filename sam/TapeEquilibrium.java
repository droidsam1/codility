package testing;

/*
 * For example, consider array A such that:

  A[0] = 3
  A[1] = 1
  A[2] = 2
  A[3] = 4
  A[4] = 3
 * 
 */
public class TapeEquilibrium {
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	int[] testCase = { 3, 1, 2, 4, 3 };
	int[] testCase1 = { -1000, 1000 };
	int[] testCase2 = { 1, 1 };

	System.out.println(solution(testCase));
	System.out.println(solution(testCase1));

	System.out.println(solution(testCase2));
    }

    public static int solution(int[] A) {
	int sumPartA = 0;
	int sumPartB = 0;
	int minDiff = Integer.MAX_VALUE;

	for (int i = 0; i < A.length; i++) {
	    sumPartA += A[i];
	}
	for (int i = A.length - 1; i > 0; i--) {
	    sumPartB += A[i];
	    sumPartA -= A[i];
	    int diff = Math.abs(sumPartA - sumPartB);
	    if (diff == 0) {
		return diff;
	    }
	    if (diff < minDiff) {
		minDiff = diff;
	    }

	}

	return minDiff;
    }

}
