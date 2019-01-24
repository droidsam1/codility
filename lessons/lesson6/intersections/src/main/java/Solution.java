class Solution {
    static int solution(int[] A) {
        final int N = A.length;

        if (N < 2) {
            return 0;
        }

        long[] leftEdges = new long[N];
        long[] rightEdges = new long[N];

        for (int i = 0; i < N; i++) {
            long r = (long) A[i];

            long left = i - r;
            leftEdges[i] = left;

            long right = i + r;
            rightEdges[i] = right;
        }

        quicksort(leftEdges, 0, N - 1);
        quicksort(rightEdges, 0, N - 1);

        int counter = 0;
        int previousCircles = 0;
        int leftP = 0;

        for (int rightP = 0; rightP < N; rightP++) {
            while ((leftP < N) && (leftEdges[leftP] <= rightEdges[rightP])) {
                leftP++;
                previousCircles++;
            }

            counter += --previousCircles;

            if (counter > 10000000) {
                return -1;
            }
        }
        return counter;
    }

    private static void quicksort(long arr[], int left, int right) {
        int index = partition(arr, left, right);

        if (left < index - 1) {
            quicksort(arr, left, index - 1);
        }

        if (index < right) {
            quicksort(arr, index, right);
        }
    }

    private static int partition(long arr[], int left, int right) {
        long pivot = arr[(left + right) / 2];

        while (left <= right) {
            while (arr[left] < pivot) {
                left++;
            }

            while (arr[right] > pivot) {
                right--;
            }

            if (left <= right) {
                long tmp = arr[left];
                arr[left++] = arr[right];
                arr[right--] = tmp;
            }
        }

        return left;
    }
}


//// you can also use imports, for example:
//// import java.util.*;
//
//// you can write to stdout for debugging purposes, e.g.
//// System.out.println("this is a debug message");
//
//class Solution {
//
//    static int solution(int[] A) {
//        int N = A.length;
//        int[] C = new int[N];
//        int a, S = 0, t = 0;
//
//        A;
//
//        // Mark left and middle of disks
//        for (int i = 0; i < N; i++) {
//            C[i] = -1;
//            a = A[i];
//            if (a >= i) {
//                C[0]++;
//            } else {
//                C[i - a]++;
//            }
//        }
//        // Sum of left side of disks at location
//        for (int i = 0; i < N; i++) {
//            t += C[i];
//            C[i] = t;
//        }
//        // Count pairs, right side only:
//        // 1. overlaps based on disk size
//        // 2. overlaps based on disks but not centers
//        for (int i = 0; i < N; i++) {
//            a = A[i];
//            S += ((a < N - i) ? a : N - i - 1);
//            if (i != N - 1) {
//                S += C[((a < N - i) ? i + a : N - 1)];
//            }
//            if (S > 10000000) {
//                return -1;
//            }
//        }
//
//        return S;
//    }
//
//}
//
////// you can also use imports, for example:
////// import java.util.*;
////
////// you can write to stdout for debugging purposes, e.g.
////// System.out.println("this is a debug message");
////
////class Solution {
////    static int solution(int[] A) {
////        int numberIntersections = 0;
////
////        for (int i = 0; i < A.length; i++) {
////            for (int j = i; j < A.length; j++) {
////                if (intersect(i, A[i], j, A[j])) {
////                    numberIntersections++;
////                    if (numberIntersections > 10000000) {
////                        return -1;
////                    }
////                }
////            }
////        }
////        return numberIntersections;
////    }
////
////    private static boolean intersect(long centerA, long radiusA, long centerB, long radiusB) {
////        if (centerA != centerB) {
////            return centerA + radiusA >= centerB || centerA + radiusA >= centerB - radiusB;
////        }
////        return false;
////    }
////}