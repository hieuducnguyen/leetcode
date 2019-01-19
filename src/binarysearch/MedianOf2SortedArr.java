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
//		int[] A = {1, 2};
//		int[] B = {1, 2, 3};
//		System.out.println(new MedianOf2SortedArr().median(A, B));
		int[] arr2 = new int[]{1, 12, 15, 26, 38};
//		int[] arr2 = new int[]{2, 13, 17, 30, 45};
		int[] arr1 = new int[]{37, 38, 39, 40, 45};
		int k = kThElement(arr1, arr2, 0, arr1.length - 1, 0, arr2.length - 1, 7);
		System.out.println("K: " + k);
	}

}
