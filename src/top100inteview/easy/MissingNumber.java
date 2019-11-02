/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100inteview.easy;

/**
 *
 * @author hieund3
 */
public class MissingNumber {

	MissingNumber Instance = new MissingNumber();

	public static void main(String[] args) {
		int[] arr = {0, 1, 2, 4};
		int missingNumber = missingNumber(arr);
		System.out.println("missingNumber: " + missingNumber);
	}

	private static int missingNumber(int[] arr) {
		int result = 0;
		for (int i = 0; i < arr.length + 1; i++) {
			result ^= i;
		}
		for (int i = 0; i < arr.length; i++) {
			result ^= arr[i];
		}
		return result;
	}
}
