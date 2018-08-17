package testing;

public class FrogRiverOne {

    /*
     * 
     * 
     * A[0] = 1 A[1] = 3 A[2] = 1 A[3] = 4 A[4] = 2 A[5] = 3 A[6] = 5 A[7] = 4
     * 
     * 
     */

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	int[] test1 = { 1, 3, 1, 4, 2, 3, 5, 4 };
	int[] test2 = { 1, 3, 1, 4, 2, 3, 1, 4 };
	int[] test3 = { 1 };

	System.out.println(solution(1, test3));
	System.out.println(solution(5, test1));
	System.out.println(solution(5, test2));

    }

    public static int solution(int X, int[] A) {
	int[] distinct = new int[X];
	int lastTime = -1;

	for (int i = 0; i < A.length; i++) {
	    if (!isAlreadyPresent(distinct, A[i])) {
		distinct[A[i] - 1] = 1;
		lastTime = i;
	    }
	}
	if (checkCompleteness(distinct)) {
	    return lastTime;
	}
	return -1;

    }

    private static boolean isAlreadyPresent(int[] distinct, int leaf) {
	return leaf <= distinct.length && leaf > 0 && distinct[leaf - 1] == 1;
    }

    private static boolean checkCompleteness(int[] distinct) {
	boolean isComplete = true;
	for (int n : distinct) {
	    isComplete = isComplete && (n == 1);
	}
	return isComplete;

    }

}
