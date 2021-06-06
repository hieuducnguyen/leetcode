package binarySearch;

import java.util.Arrays;

public class _1351_CountNegativeNumbersInASortedMatrix {
	public static final _1351_CountNegativeNumbersInASortedMatrix INSTANCE =
		new _1351_CountNegativeNumbersInASortedMatrix();

	public int countNegatives2(int[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}
		int colIndex = grid[0].length - 1, rowIndex = 0, result = 0;
		while (colIndex >= 0 && rowIndex <= grid.length - 1) {
			if (grid[rowIndex][colIndex] < 0) {
				result += (grid.length - rowIndex);
				colIndex--;
			} else {
				rowIndex++;
			}
		}
		return result;
	}

	public int countNegatives(int[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}
		int result = 0, preFirstNeg = grid[0].length;
		for (int[] ints : grid) {
			preFirstNeg = binSearchFirstNegative(Arrays.copyOfRange(ints, 0, preFirstNeg));
			result += (grid[0].length - preFirstNeg);
		}
		return result;

	}

	private boolean hasNegative(int[] ints, int firstNegative) {
		return firstNegative != ints.length;
	}

	int binSearchFirstNegative(int[] arr) {
		int r = 0, l = arr.length, m;
		while (r < l) {
			m = (r + l) / 2;
			if (arr[m] < 0 && (m == 0 || arr[m - 1] >= 0)) {
				return m;
			} else if (arr[m] >= 0) {
				r = m + 1;
			} else {
				l = m;
			}
		}
		return l;
	}
}
