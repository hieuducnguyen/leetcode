/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like.easy;

/**
 *
 * @author HieuDucNguyen
 */
public class MaxSubArray {

	public static void main(String[] args) {
		int[] arr = new int[]{1, 2, -3, 4, 5};
		int ret = process3(arr);
		System.out.println("ret: " + ret);
	}

	private static int process(int[] arr) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			int sum = 0;
			int currMax = Integer.MIN_VALUE;
			for (int j = i; j >= 0; j--) {
				sum += arr[j];
				if (sum > currMax) {
					currMax = sum;
				}
			}
			if (currMax > max) {
				max = currMax;
			}
		}
		return max;
	}

	private static int process1(int[] arr) {
		int index1 = 0, index2 = 0;
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			int currMax = 0;
			index2 = i;
			int curIndex1 = index1;
			for (int j = i; j >= index1; j--) {
				currMax += arr[j];
				if (currMax > max) {
					max = currMax;
					curIndex1 = j;
				}
			}
			index1 = curIndex1;
		}
		return max;
	}

	private static int process3(int[] arr) {
		int max = arr[0];
		int index2 = 0;
		for (int i = 1; i < arr.length; i++) {
			int maxCurSum = Integer.MIN_VALUE;
			int curSum = 0;
			for (int j = i; j > index2; j--) {
				curSum += arr[j];
				if (maxCurSum < curSum) {
					maxCurSum = curSum;
				}
			}
			int compareSum = max + curSum;
			if (maxCurSum > compareSum) {
				max = maxCurSum;
				index2 = i;
			} else {
				max = compareSum;
			}
		}
		return max;
	}

	
}
