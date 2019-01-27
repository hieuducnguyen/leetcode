/*
 *  Copyright (c) 2012-2018 by Zalo Group.
 *  All Rights Reserved.
 */
package binarysearch;

import static basic.BasicTest.POSITION_NOT_FOUND;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hieund3
 */
public class LIS {

	public static int maxScore = 0;

	static class Item {

		int value;
		int len;
	}

	public static int findInsertPosInList(int value, List<Item> list) {
		if (list == null) {
			return POSITION_NOT_FOUND;
		}
		if (list.isEmpty()) {
			return 0;
		}
		int len = list.size();
		int left = 0, right = len - 1;
		int mid;
		while (left <= right) {
			mid = (left + right) / 2;
			if (list.get(mid).value < value) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return left;
	}

	private static void addItemToList(int val, List<Item> itemList) {
		int pos = findInsertPosInList(val, itemList);
		Item a = new Item();
		a.value = val;
		if (itemList.size() - 1 >= pos) {
			a.len = maxScore + 1;
		} else {
			a.len = 1;
		}
		if (a.len > maxScore) {
			maxScore = a.len;
		}
		itemList.add(pos, a);
	}

	public static int process(int[] arr) {
		List<Item> itemList = new ArrayList<>();
		int len = arr.length;
		for (int i = (len - 1); i >= 0; i--) {
			addItemToList(arr[i], itemList);
		}
		if (itemList.isEmpty()) {
			return 0;
		} else {
			return itemList.get(0).len;
		}
	}

	public static void main(String[] args) {
//		int[] arr = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
		int[] arr = new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6};
//		List<Integer> list = Arrays.asList(1, 2, 4, 7);
//		int pos = findInsertPosInList(9, list);
		int len = process(arr);
		System.out.println("len: " + len);
	}
}
