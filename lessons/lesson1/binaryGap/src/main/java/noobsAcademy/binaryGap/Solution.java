// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
package noobsAcademy.binaryGap;

public class Solution {
    // Must return the max number of consecutive 0s between 1s
    // Example: N = 41 -> Binary = 101001 -> Máx = 2
    // Example: N = 40 -> Binary = 101000 -> Máx = 1
    public static int solution(int N) {
	// TODO implementar tu código aqui
	String binaryString = Integer.toBinaryString(N);
	int maxNumberOfConsecutiveZeros = 0;
	int zerosCounter = 0;
	for (char c : binaryString.toCharArray()) {
	    if (c == '0') {
		zerosCounter++;
	    } else {
		maxNumberOfConsecutiveZeros = getMax(zerosCounter, maxNumberOfConsecutiveZeros);
		zerosCounter = 0;
	    }
	}
	return maxNumberOfConsecutiveZeros;
    }

    private static int getMax(int zerosCounter, int maxNumberOfConsecutiveZeros) {
	if (zerosCounter > maxNumberOfConsecutiveZeros) {
	    return zerosCounter;
	}
	return maxNumberOfConsecutiveZeros;
    }
}