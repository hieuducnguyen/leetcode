/*
 *  Copyright (c) 2012-2018 by Zalo Group.
 *  All Rights Reserved.
 */
package top100like.medium;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hieund3
 */
public class Permutation {

	// note dùng queue hay vì list of list, dk dừng là queue đó có size bằng 7 (arr.length)
	public static List<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();

	private static int process(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (lists.isEmpty()) {
				ArrayList<Integer> list = new ArrayList<>();
				list.add(arr[i]);
				lists.add(list);
			} else {
				for (int j = 0; j < lists.size(); j++) {

				}
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
		int num = process(arr);
	}
}
