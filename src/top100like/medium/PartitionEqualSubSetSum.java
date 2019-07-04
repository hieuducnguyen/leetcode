/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like.medium;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author hieund3
 */
public class PartitionEqualSubSetSum {

	public static void main(String[] args) {
		int[] arr = new int[]{1, 5, 11, 5};
		boolean result = process(arr);
		System.out.println("result " + result);
	}

	private static boolean process(int[] arr) {
		if (arr.length == 0) {
			return false;
		}
		if (arr.length == 1) {
			return arr[0] == 0;
		}
		Set<Integer> set = new HashSet<>();
		Set<Integer> tmpSet;
		set.add(arr[0]);
		set.add(-arr[0]);
		for (int i = 1; i < arr.length - 1; i++) {
			tmpSet = set;
			set = new HashSet<>();
			for (Integer value : tmpSet) {
				set.add(value + arr[i]);
				set.add(value - arr[i]);
			}
		}
		return set.contains(arr[arr.length - 1]) || set.contains(-arr[arr.length - 1]);
	}
}
