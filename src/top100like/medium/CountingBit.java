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
public class CountingBit {

	public static void main(String[] args) {
		int num = 4;
		int[] arr = process1(num);
		basic.BasicTest.printArrayInt(arr);
	}

	private static int[] process(int num) {
		int[] result = new int[num + 1];
		for (int i = 1; i <= num; i++) {
			int j = 0;
			int temp = i;
			while (temp != 0) {
				j += (temp & 1);
				temp /= 2;
			}
			result[i] = j;
		}
		return result;
	}

	private static int[] process1(int num) {
		int[] result = new int[num + 1];
		for (int i = 1; i <= num; i++) {
			result[i] = result[i / 2] + (i & 1);
		}
		return result;
	}
}
