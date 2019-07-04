/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like.medium;

/**
 *
 * @author hieund3
 */
public class UniqueBST {

	public static void main(String[] args) {
		int value = 4;
		int result = process(value);
		System.out.println("result: " + result);
	}

	private static int process(int value) {
		int[] arr = new int[value + 1];
		arr[0] = 0;
		for (int i = 1; i <= value; i++) {
			int num = 0;
			for (int j = 1; j <= i; j++) {
				num += (Math.max(arr[j - 1], 1) * Math.max(arr[i - j], 1));
			}
			arr[i] = num;
		}
		return arr[value];
	}
}
