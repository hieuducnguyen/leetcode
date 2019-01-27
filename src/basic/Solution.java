/*
 *  Copyright (c) 2012-2018 by Zalo Group.
 *  All Rights Reserved.
 */
package basic;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hieund3
 */
public class Solution {

	public static final int POSITION_NOT_FOUND = -1;
	public static final int EXIST = -2;

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
		int mid = (left + right) / 2;
		while (left <= right) {
			if (list.get(mid).value < value) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
			mid = (left + right) / 2;
		}
		return left;
	}

	private static void addItemToList(int val, List<Item> itemList) {
		int pos = findInsertPosInList(val, itemList);
		if (pos == EXIST) {
			return;
		}
		Item a = new Item();
		if (itemList.size() - 1 >= pos) {
			a.len = itemList.get(pos).len + 1;
			a.value = val;
		} else {
			a.len = 1;
			a.value = val;
		}
		itemList.add(pos, a);
	}

	public static int lengthOfLIS(int[] nums) {
		List<Item> itemList = new ArrayList<>();
		int len = nums.length;
		for (int i = (len - 1); i >= 0; i--) {
			addItemToList(nums[i], itemList);
		}
		if (itemList.isEmpty()) {
			return 0;
		} else {
			return itemList.get(0).len;
		}
	}

	public static void main(String[] args) {
		int[] nums = new int[]{2,2};
		int len = lengthOfLIS(nums);
		System.out.println("len: " + len);
	}
}
