package noobsAcademy.numberofdiscintersections;

import java.util.HashSet;
import java.util.Set;

/**
 * We draw N discs on a plane. The discs are numbered from 0 to N − 1. An array
 * A of N non-negative integers, specifying the radiuses of the discs, is given.
 * The J-th disc is drawn with its center at (J, 0) and radius A[J].
 * 
 * We say that the J-th disc and K-th disc intersect if J ≠ K and the J-th and
 * K-th discs have at least one common point (assuming that the discs contain
 * their borders).
 * 
 * The figure below shows discs drawn for N = 6 and A as follows:
 * 
 * A[0] = 1 A[1] = 5 A[2] = 2 A[3] = 1 A[4] = 4 A[5] = 0
 * 
 * 
 * There are eleven (unordered) pairs of discs that intersect, namely:
 * 
 * discs 1 and 4 intersect, and both intersect with all the other discs; disc 2
 * also intersects with discs 0 and 3. Write a function:
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * that, given an array A describing N discs as explained above, returns the
 * number of (unordered) pairs of intersecting discs. The function should return
 * −1 if the number of intersecting pairs exceeds 10,000,000.
 * 
 * Given array A shown above, the function should return 11, as explained above.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an integer within the range [0..100,000]; each element of array A is an
 * integer within the range [0..2,147,483,647].
 *
 */
public class Solution {
    public static int solution(int[] A) {

	Set<Intersection> intersections = new HashSet<Intersection>();

	for (int i = 0; i < A.length; i++) {
	    int radius = A[i];
	    for (int j = i - radius; j <= i + radius; j++) {
		if (j != i && j >= 0 && j < A.length) {
		    intersections.add(new Intersection(i, j));
		}
	    }
	}
	return intersections.size();
    }

    public static class Intersection {
	int a;
	int b;

	public Intersection(int a, int b) {
	    this.a = a < b ? a : b;
	    this.b = a < b ? b : a;
	}

	@Override
	public int hashCode() {
	    final int prime = 31;
	    int result = 1;
	    result = prime * result + a + b;
	    return result;

	}

	@Override
	public boolean equals(Object obj) {
	    if (!(obj instanceof Solution.Intersection)) {
		return false;
	    }
	    final Solution.Intersection other = (Solution.Intersection) obj;
	    return (other.a == this.a || other.a == this.b) && (other.b == this.b || other.b == this.a);
	}

	@Override
	public String toString() {
	    StringBuilder builder = new StringBuilder();
	    builder.append("[").append(a).append(",").append(b).append("]");
	    return builder.toString();
	}

    }
}
