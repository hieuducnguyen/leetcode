/*
 *  Copyright (c) 2012-2018 by Zalo Group.
 *  All Rights Reserved.
 */
package heap;

import basic.BasicTest;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hieund3
 */
public class MaxHeapImpl implements IMaxHeap {

	private static final List<Integer> list = new ArrayList<>();
	private static List<Integer> listIndex = new ArrayList<>();

	@Override
	public void add(Integer value) {;
		int i = 0;
		listIndex.add(i);
		int len = list.size();
		int lastValue = value;
		while (listIndex.get(0) < len) {
			i = listIndex.get(0);
			final Integer valueCompare = list.get(i);
			if (valueCompare < lastValue) {
				list.set(listIndex.get(0), BasicTest.swap2Element(lastValue, lastValue = valueCompare));
			}
			listIndex.remove(0);
			int x = 2 * i + 1;
			int y = 2 * i + 2;
			listIndex.add(x);
			listIndex.add(y);
		}
		listIndex = new ArrayList<>();
		list.add(lastValue);
	}

	@Override
	public Integer peek() {
		return list.get(0);
	}

	@Override
	public Integer pop() {
		int size = list.size();
		if (size == 0) {
			return null;
		}
		if (size == 1) {
			Integer peek = list.get(0);
			list.remove(0);
			return peek;
		}
		Integer peek = list.get(0);
		Integer last = list.get(size - 1);
		list.remove(size - 1);
		list.remove(0);
		add(last);
		return peek;

	}

	public static void main(String[] args) {
		MaxHeapImpl heap = new MaxHeapImpl();
		heap.add(1);
		heap.add(3);
		heap.add(8);
		heap.pop();
		heap.add(9);
		heap.add(5);
		heap.pop();
		heap.add(6);
		System.out.println("list: " + heap.list);
	}

}
