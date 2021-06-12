package binarySearch;

/*
 * Created by hieund3 on 06/06/2021
 */

import java.util.*;

public class _1337_TheKWeakestRowsInAMatrix {
	public static final _1337_TheKWeakestRowsInAMatrix INSTANCE =
		new _1337_TheKWeakestRowsInAMatrix();

//	public static void main(String[] args) {
//		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.naturalOrder());
//		pq.add(2);
//		pq.add(1);
//		final Integer poll = pq.poll();
//		System.out.println("poll = " + poll);
//	}


	public int[] kWeakestRows(int[][] mat, int k) {
		if (mat == null || mat.length == 0 || k < 0) {
			return null;
		}
		PriorityQueue<int[]> queue = new PriorityQueue<>((soldierFirst, soldierSecond) -> (
			soldierFirst[0] != soldierSecond[0] ? -(soldierFirst[0] - soldierSecond[0])
				: -(soldierFirst[1] - soldierSecond[1])
		));
		for (int i = 0; i < mat.length; i++) {
			int numOne = countOne(mat[i]) + 1;
			queue.add(new int[]{numOne, i});
			if (queue.size() > k) {
				queue.poll();
			}
		}
		int[] result = new int[k];
		for (int i = k - 1; i >= 0; i--) {
			result[i] = Objects.requireNonNull(queue.poll())[1];
		}
		return result;
	}

	private int countOne(int[] ints) {
		int index = findFirstOne(ints);
		return ++index;
	}

	private int findFirstOne(int[] ints) {
		int r = 0, l = ints.length, m;
		while (r < l) {
			m = (r + l) / 2;
			if (ints[m] == 1 && (m == ints.length - 1 || ints[m + 1] == 0)) {
				return m;
			} else if (ints[m] == 0) {
				l = m;
			} else {
				r = m + 1;
			}
		}
		return -1;
	}

	public int[] kWeakestRows1(int[][] mat, int k) {
		if (mat == null || k < 0) {
			return null;
		}
		final List<SoldierStruct> soldierList = new ArrayList<>();
		for (int i = 0; i < mat.length; i++) {
			final int soldier = countSoldier(mat[i]);
			final SoldierStruct soldierStruct = new SoldierStruct(i, soldier);
			soldierList.add(soldierStruct);
		}
		Collections.sort(soldierList);
		int[] result = new int[k];
		for (int i = 0; i < k; i++) {
			result[i] = soldierList.get(i).index;
		}
		return result;
	}

	public class SoldierStruct implements Comparable<SoldierStruct> {
		int index;
		int numSoldier;

		public SoldierStruct(int index, int numSoldier) {
			this.index = index;
			this.numSoldier = numSoldier;
		}

		@Override
		public int compareTo(SoldierStruct o) {
			if (this.numSoldier != o.numSoldier) {
				return this.numSoldier - o.numSoldier;
			}
			return this.index - o.index;
		}
	}

	private int countSoldier(int[] arr) {
		final int firstSoldier = findFirstSoldier(arr);
		if (firstSoldier == -1) {
			return 0;
		}
		return firstSoldier + 1;
	}

	int findFirstSoldier(int[] arr) {
		int r = 0, l = arr.length, m;
		while (r < l) {
			m = (r + l) / 2;
			if (arr[m] == 1 && (m == arr.length - 1 || arr[m + 1] == 0)) {
				return m;
			} else if (arr[m] == 0) {
				l = m;
			} else {
				r = m + 1;
			}
		}
		return -1;
	}
}
