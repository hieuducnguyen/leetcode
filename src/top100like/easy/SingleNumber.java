/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like.easy;

import java.util.HashSet;

/**
 *
 * @author HieuDucNguyen
 */
public class SingleNumber {

	private static int process(int[] arr) {
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			if (set.contains(arr[i])) {
				set.remove(arr[i]);
			} else {
				set.add(arr[i]);
			}
		}
		return set.iterator().next();
	}

	public static void main(String[] args) {
		int[] arr = new int[]{4, 1, 2, 1, 2};
		int singleNum = process1(arr);
		System.out.println("single number: " + singleNum);
	}

	private static int process1(int[] arr) {
		int result = 0;
		for (int i = 0; i < arr.length; i++) {
			result ^= arr[i];
		}
		return result;
	}
}
