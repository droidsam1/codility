package noobsAcademy.passingCars;

/**
 * A non-empty array A consisting of N integers is given. The consecutive
 * elements of array A represent consecutive cars on a road.
 * 
 * Array A contains only 0s and/or 1s:
 * 
 * 0 represents a car traveling east, 1 represents a car traveling west. The
 * goal is to count passing cars. We say that a pair of cars (P, Q), where 0 ≤ P
 * < Q < N, is passing when P is traveling to the east and Q is traveling to the
 * west.
 * 
 * The function should return −1 if the number of pairs of passing cars exceeds
 * 1,000,000,000.
 * 
 */
public class Solution {
    public static int solution(int[] A) {
	final int TRAVELLING_EAST = 0;
	int[] passingCarsForCarAtIndex = calculateSumPassingCarsForEachCar(A);

	int totalPassingCars = 0;
	for (int index = 0; index < A.length; index++) {
	    if (A[index] == TRAVELLING_EAST) {
		int numberOfPassingCarsForCarAtIndex = passingCarsForCarAtIndex[index];
		totalPassingCars = totalPassingCars + numberOfPassingCarsForCarAtIndex;
	    }
	    if (totalPassingCars > 1000000000) {
		return -1;
	    }
	}

	return totalPassingCars;

    }

    private static int[] calculateSumPassingCarsForEachCar(int[] A) {
	return calculateSufixSum(A);
    }

    private static int[] calculateSufixSum(int[] inputArr) {
	int[] sufixSum = new int[inputArr.length];
	sufixSum[inputArr.length - 1] = inputArr[inputArr.length - 1];

	for (int i = inputArr.length - 2; i >= 0; i--) {
	    sufixSum[i] = inputArr[i] + sufixSum[i + 1];
	}
	return sufixSum;

    }
    // Just for practice
    // private static int[] calculatePrefixSum(int[] inputArr) {
    // int[] prefixSum = new int[inputArr.length];
    // prefixSum[0] = inputArr[0];
    // for (int i = 1; i < inputArr.length; i++) {
    // prefixSum[i] = inputArr[i] + prefixSum[i - 1];
    // }
    // return prefixSum;
    //
    // }
}
