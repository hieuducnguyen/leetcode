package binarySearch;

public class _1351_CountNegativeNumbersInASortedMatrix {
	public static final _1351_CountNegativeNumbersInASortedMatrix INSTANCE = new _1351_CountNegativeNumbersInASortedMatrix();

	int countNegatives(int[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}
		int i = 0, j = grid[0].length - 1, temp, result = 0;
		while (i < grid.length && j >= 0) {
			temp = grid[i][j];
			if (temp < 0) {
				result += (grid.length - i);
				j--;
			} else {
				i++;
			}
		}
		// test 1
		// test 2
		// test 3
		// test 4
		return result;
	}

	public static void main(String[] args) {
		int[][] grid = {{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}};
		System.out.println("\"test\" = " + "test");
	}
}
