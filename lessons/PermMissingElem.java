/**
 * 
 */
package testing;

public class PermMissingElem {

    class Solution {
	public int solution(int[] A) {
	    int totalSum = 0;
	    long max = A.length + 1L;

	    for (int element : A) {
		totalSum += element;
	    }

	    int sumWithMissinElement = (int) (max * (max + 1) / 2);
	    return sumWithMissinElement - totalSum;
	}
    }
}

/*
 * Suma de los n primeros n enteros positivos
 * https://es.wikipedia.org/wiki/Progresión_aritmética#Ejemplos_notables
 * 
 */

// 1 2 3 4= ... (n-3) + (n-2) + (n-1) + n
// ----------------------------------------------
// 2S = 2n + 2(n-1) + 2(n-2) + 2(n-3)
// //para n=3
// = 2n + 2(n-1) + 2(n-2)
// = 2n +2n -2 +2n -4
// = 6n- 6
// =2n*n - n(n-1)
// =n(2n - (n-1))
// S=n(n+1)/2;
//
// //para n=4
// 2n + 2(n-1) + 2(n-2) + 2(n-3)
// 2n + 2n -2 -2n -4 +2n -6
// 2S = 8n -12
// 2S = 2n*n - n(n-1)
// 2S = n(2n - (n-1))
// S = n (n+1)/2;
