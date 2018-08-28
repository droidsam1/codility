package noobsAcademy.genomicrangequery;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

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
public class Solution2 {

    private enum NUCLEOTIDES {
	A(1, 'A'), C(2, 'C'), G(3, 'G'), T(4, 'T');

	private final int impact;
	private final char letter;

	private NUCLEOTIDES(int impact, char letter) {
	    this.impact = impact;
	    this.letter = letter;
	}

	public char getLetter() {
	    return letter;
	}

	public static NUCLEOTIDES[] getNucleotidesOrderedByImpact() {
	    NUCLEOTIDES[] ordered = NUCLEOTIDES.values();
	    Arrays.sort(ordered, new Comparator<NUCLEOTIDES>() {
		public int compare(NUCLEOTIDES o1, NUCLEOTIDES o2) {
		    return Integer.compare(o1.impact, o2.impact);
		}

	    });
	    return ordered;
	}

    }

    private static class SumPrefix {
	private int[] sumPrefixArray;

	public SumPrefix(int arraySize) {
	    this.sumPrefixArray = new int[arraySize];
	}

	public int getSumPrefixAt(int index) {
	    assert (index >= 0 && index < sumPrefixArray.length);
	    return sumPrefixArray[index];
	}

	public void setSumPrefixAt(int index, int value) {
	    assert (index >= 0 && index < sumPrefixArray.length);
	    this.sumPrefixArray[index] = value;
	}

    }

    private static Map<NUCLEOTIDES, SumPrefix> generateNucleotidesPrefixSumMap(int arraySize) {
	Map<NUCLEOTIDES, SumPrefix> sumPrefixByNucleotide = new HashMap<NUCLEOTIDES, SumPrefix>();
	for (NUCLEOTIDES nucleotide : NUCLEOTIDES.getNucleotidesOrderedByImpact()) {
	    sumPrefixByNucleotide.put(nucleotide, new SumPrefix(arraySize));
	}
	return sumPrefixByNucleotide;
    }

    public static int[] solution(String S, int[] P, int[] Q) {
	// return Solution2.solution(S, P, Q);
	assert (P.length == Q.length);

	Map<NUCLEOTIDES, SumPrefix> sumPrefixByNucleotide = generateNucleotidesPrefixSumMap(S.length());
	char[] dnaArray = S.toCharArray();
	NUCLEOTIDES[] orderedNucleotides = NUCLEOTIDES.getNucleotidesOrderedByImpact();
	for (int i = 0; i < S.length(); i++) {
	    for (NUCLEOTIDES nu : orderedNucleotides) {
		int indexOfPreviousElement = i - 1;
		if (indexOfPreviousElement < 0) {
		    indexOfPreviousElement = 0;
		}
		Integer last = sumPrefixByNucleotide.get(nu).getSumPrefixAt(indexOfPreviousElement);
		if (dnaArray[i] == nu.getLetter()) {
		    last++;
		}
		if (last != 0) {
		    sumPrefixByNucleotide.get(nu).setSumPrefixAt(i, last);
		}
	    }
	}
	int[] result = new int[P.length];
	for (int i = 0; i < P.length; i++) {
	    int lowerPos = P[i];
	    int upperPos = Q[i];
	    result[i] = getMinImpact(orderedNucleotides, sumPrefixByNucleotide, lowerPos, upperPos);
	}
	return result;
    }

    private static int getMinImpact(NUCLEOTIDES[] orderedNucleotides, Map<NUCLEOTIDES, SumPrefix> sumPrefixByNucleotide,
	    int lowerPos, int upperPos) {
	int minImpact = Integer.MAX_VALUE;
	for (NUCLEOTIDES nu : orderedNucleotides) {
	    int upper = sumPrefixByNucleotide.get(nu).getSumPrefixAt(upperPos);
	    if (upper != 0) {
		int lower = 0;
		if (lowerPos != 0) {
		    lower = sumPrefixByNucleotide.get(nu).getSumPrefixAt(lowerPos - 1);
		}
		if (upper - lower > 0) {
		    return nu.impact;
		}
	    }

	}

	return minImpact;
    }

    // public static int[] solution(String S, int[] P, int[] Q) {
    // assert (P.length == Q.length);
    // int[] result = new int[P.length];
    //
    // char[] dnaArray = S.toCharArray();
    // for (int i = 0; i < P.length; i++) {
    // int lowerPos = P[i];
    // int upperPos = Q[i];
    // result[i] = getMinImpact(dnaArray, lowerPos, upperPos);
    // }
    // return result;
    // }
    //
    // private static int getMinImpact(char[] dnaArray, int lowerPos, int
    // upperPos) {
    // int minImpact = Integer.MAX_VALUE;
    // for (int i = lowerPos; i <= upperPos; i++) {
    // char nucleotideName = dnaArray[i];
    // int impact = NUCLEOTIDES.getImpact(String.valueOf(nucleotideName));
    // if (impact == 1) {
    // return 1;
    // }
    // if (minImpact > impact) {
    // minImpact = impact;
    // }
    // }
    // return minImpact;
    // }

}


