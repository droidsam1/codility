/**
 * 
 */
package testing;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class OddOccurrencesInArray {

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	int[] testCase = { 1, 7, 9, 3, 1, 1, 9, 3, 7, 1, 9, 7, 7, 1, 9 };
	System.out.println(solution(testCase));
    }

    public static int solution(int[] A) {
	// write your code in Java SE 8
	int result = 0;
	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	for (int i = 0; i < A.length; i++) {
	    if (map.containsKey(A[i])) {
		map.put(A[i], map.get(A[i]) + 1);
	    } else {
		map.put(A[i], 1);
	    }
	}

	for (Entry<Integer, Integer> entry : map.entrySet()) {
	    if (entry.getValue() % 2 != 0) {
		return result = entry.getKey();
	    }
	    // System.out.println(entry.getKey() + " ----" + entry.getValue());

	}

	return result;
    }

}
