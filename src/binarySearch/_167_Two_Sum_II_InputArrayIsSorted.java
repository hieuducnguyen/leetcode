package binarySearch;

/*
 * Created by hieund3 on 13/06/2021
 */
public class _167_Two_Sum_II_InputArrayIsSorted {
	public static final _167_Two_Sum_II_InputArrayIsSorted INSTANCE = new _167_Two_Sum_II_InputArrayIsSorted();

	public int[] twoSum(int[] numbers, int target) {
		for (int i = 0; i < numbers.length - 1; i++) {
			int value = target - numbers[i];
			int result = binSearch(numbers, value, i + 1, numbers.length);
			if (result != -1 && result != i) {
				return new int[]{i + 1, result + 1};
			}
		}
		return new int[]{};
	}

	private int binSearch(int[] numbers, int value, int l, int r) {
		int m;
		while (l < r) {
			m = (l + r) / 2;
			if (numbers[m] == value) {
				return m;
			} else if (numbers[m] < value) {
				l = m + 1;
			} else {
				r = m;
			}
		}
		return -1;
	}
}
