/*
 *  Copyright (c) 2012-2018 by Zalo Group.
 *  All Rights Reserved.
 */
package binarysearch;

/**
 *
 * @author hieund3
 */
public class MedianOf2SortedArr {

	public static int kThElement(int[] A, int[] B, int aStart, int aEnd, int bStart, int bEnd, int k) {
		int aL = aEnd - aStart + 1;
		int bL = bEnd - bStart + 1;

		if (aL == 0) {
			return B[bStart + k];
		}
		if (bL == 0) {
			return A[aStart + k];
		}

		if (k == 0) {
			return A[aStart] <= B[bStart] ? A[aStart] : B[bStart];
		}

		int aSplit = aL * k / (aL + bL);
		int bSplit = k - aSplit - 1;

		aSplit = aStart + aSplit;
		bSplit = bStart + bSplit;

		// A[aStart .. aSplit] is less than the kth element
		// B[bSplit .. bEnd] is larger than the kth element
		if (A[aSplit] <= B[bSplit]) {
			int newK = k - (aSplit - aStart + 1);
			return kThElement(A, B, aSplit + 1, aEnd, bStart, bSplit, newK);
		} else {
			//B[bStart .. bSplit] is less than the kTh element
			//A[aSplit .. aEnd] is larger than the kTh element
			int newK = k - (bSplit - bStart + 1);
			return kThElement(A, B, aStart, aSplit, bSplit + 1, bEnd, newK);
		}
	}

	public static double findKthSmallestElement(int[] A, int[] B, int k) {
		int lenA = A.length;
		int lenB = B.length;
		if (lenA + lenB < k) {
			return -1;
		}
		int iMin = 0;
		int iMax = Integer.min(A.length, k - 1);

		int i;
		int j;

		while (iMin <= iMax) {
			i = (iMin + iMax) / 2;
			j = k - 1 - i; // because of zero based index
			if (j > 0 && B[j - 1] > A[i]) {
				// i is too small, must increase it
				iMin = i + 1;
			} else if (i > 0 && A[i - 1] > B[j]) {
				// i is too big, must decrease it
				iMax = i - 1;
			} else {
				// i is perfect
				return Integer.min(A[i], B[j]);
			}
		}
		return -1;
	}

	public double median(int[] A, int[] B) {
		int total = A.length + B.length;
		if (total % 2 == 1) {
			return kThElement(A, B, 0, A.length - 1, 0, B.length - 1, total / 2);
		} else {
			return (kThElement(A, B, 0, A.length - 1, 0, B.length - 1, (total - 1) / 2)
					+ kThElement(A, B, 0, A.length - 1, 0, B.length - 1, total / 2)) / 2.0;
		}

	}

	
	public static void main(String[] args) {
		
	}

}
