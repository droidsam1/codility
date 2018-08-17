package one;

public class PermCheck {

	public static void main(String[] args) {

		int[] A1 = new int[] { 5, 4, 3, 2, 1 };
		int[] A2 = new int[] { 2, 2, 2 };
		System.out.println(solution(A1));
		System.out.println(solution(A2));

	}

	public static int solution(int[] A) {

		int N = A.length;
		int[] B = new int[N];
		for (int number : A) {
			int index = number - 1;
			if (isWithinRange(index, N) && B[index] != 1) {
				B[index] = 1;
			} else {
				return 0;
			}
		}
		return 1;
	}

	private static boolean isWithinRange(int index, int length) {
		return index >= 0 && index < length;
	}
}
