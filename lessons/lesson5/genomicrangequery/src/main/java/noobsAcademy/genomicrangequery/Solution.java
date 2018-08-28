
package noobsAcademy.genomicrangequery;

/**
 * A DNA sequence can be represented as a string consisting of the letters A, C,
 * G and T, which correspond to the types of successive nucleotides in the
 * sequence. Each nucleotide has an impact factor, which is an integer.
 * Nucleotides of types A, C, G and T have impact factors of 1, 2, 3 and 4,
 * respectively. You are going to answer several queries of the form: What is
 * the minimal impact factor of nucleotides contained in a particular part of
 * the given DNA sequence?
 * 
 * The DNA sequence is given as a non-empty string S = S[0]S[1]...S[N-1]
 * consisting of N characters. There are M queries, which are given in non-empty
 * arrays P and Q, each consisting of M integers. The K-th query (0 ≤ K < M)
 * requires you to find the minimal impact factor of nucleotides contained in
 * the DNA sequence between positions P[K] and Q[K] (inclusive).
 * 
 * For example, consider string S = CAGCCTA and arrays P, Q such that:
 * 
 * P[0] = 2 Q[0] = 4 P[1] = 5 Q[1] = 5 P[2] = 0 Q[2] = 6 The answers to these M
 * = 3 queries are as follows:
 * 
 * The part of the DNA between positions 2 and 4 contains nucleotides G and C
 * (twice), whose impact factors are 3 and 2 respectively, so the answer is 2.
 * The part between positions 5 and 5 contains a single nucleotide T, whose
 * impact factor is 4, so the answer is 4. The part between positions 0 and 6
 * (the whole string) contains all nucleotides, in particular nucleotide A whose
 * impact factor is 1, so the answer is 1.
 *
 */
public class Solution {

    public static int[] solution(String S, int[] P, int[] Q) {
	assert (P.length == Q.length);

	int[] sumPrefixA = new int[S.length()];
	int[] sumPrefixC = new int[S.length()];
	int[] sumPrefixG = new int[S.length()];
	int[] sumPrefixT = new int[S.length()];

	char[] dnaArray = S.toCharArray();

	sumPrefixA[0] = dnaArray[0] == 'A' ? 1 : 0;
	sumPrefixC[0] = dnaArray[0] == 'C' ? 1 : 0;
	sumPrefixG[0] = dnaArray[0] == 'G' ? 1 : 0;
	sumPrefixT[0] = dnaArray[0] == 'T' ? 1 : 0;

	for (int i = 1; i < S.length(); i++) {
	    sumPrefixA[i] = sumPrefixA[i - 1];
	    sumPrefixC[i] = sumPrefixC[i - 1];
	    sumPrefixG[i] = sumPrefixG[i - 1];
	    sumPrefixT[i] = sumPrefixT[i - 1];
	    if (dnaArray[i] == 'A') {
		sumPrefixA[i] = sumPrefixA[i] + 1;
	    } else if (dnaArray[i] == 'C') {
		sumPrefixC[i] = sumPrefixC[i] + 1;
	    } else if (dnaArray[i] == 'G') {
		sumPrefixG[i] = sumPrefixG[i] + 1;
	    } else if (dnaArray[i] == 'T') {
		sumPrefixT[i] = sumPrefixT[i] + 1;
	    }
	}
	int[] result = new int[P.length];
	for (int i = 0; i < P.length; i++) {
	    int lowerPos = P[i];
	    int upperPos = Q[i];

	    if (lowerPos == upperPos) {
		if (dnaArray[lowerPos] == 'A') {
		    result[i] = 1;
		} else if (dnaArray[lowerPos] == 'C') {
		    result[i] = 2;
		} else if (dnaArray[lowerPos] == 'G') {
		    result[i] = 3;
		} else if (dnaArray[lowerPos] == 'T') {
		    result[i] = 4;
		}
		continue;
	    }
	    if (lowerPos != 0) {
		lowerPos = lowerPos - 1;
	    }

	    if (sumPrefixA[upperPos] - sumPrefixA[lowerPos] > 0 || sumPrefixA[lowerPos] != 0 && lowerPos == 0) {
		result[i] = 1;
		continue;
	    }
	    if (sumPrefixC[upperPos] - sumPrefixC[lowerPos] > 0 || sumPrefixC[lowerPos] != 0 && lowerPos == 0) {
		result[i] = 2;
		continue;
	    }
	    if (sumPrefixG[upperPos] - sumPrefixG[lowerPos] > 0 || sumPrefixG[lowerPos] != 0 && lowerPos == 0) {
		result[i] = 3;
		continue;
	    }
	    if (sumPrefixT[upperPos] - sumPrefixT[lowerPos] > 0 || sumPrefixT[lowerPos] != 0 && lowerPos == 0) {
		result[i] = 4;
		continue;
	    }
	}
	return result;
    }

}
