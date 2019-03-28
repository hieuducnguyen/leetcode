/*
 *  Copyright (c) 2012-2018 by Zalo Group.
 *  All Rights Reserved.
 */
package top100like.medium;

/**
 *
 * @author hieund3
 */
public class Permutation {

	public static void main(String[] args) {
		int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
		int num = process(arr);
	}

	private static int process(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int[] index = new int[arr.length];
		int num = 0;
		for (int i = 0; i < arr.length; i++) {
			
		}
	}

	private static void reset(int[] indexArr) {
		for (int i = 0; i < indexArr.length; i++) {
			indexArr[i] = 0;
		}
	}
}
