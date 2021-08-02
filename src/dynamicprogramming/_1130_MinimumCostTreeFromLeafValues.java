package dynamicprogramming;

/*
 * Created by hieund3 on 28/07/2021
 */
public class _1130_MinimumCostTreeFromLeafValues {
	public static final _1130_MinimumCostTreeFromLeafValues INSTANCE = new _1130_MinimumCostTreeFromLeafValues();

	public int mctFromLeafValues(int[] arr) {
		Struct[][] minCostTree = new Struct[arr.length][arr.length];
		final Struct struct = mctFromLeafValues(arr, 0, arr.length - 1, minCostTree);
		return struct.minSum;
	}

	private Struct mctFromLeafValues(int[] arr, int start, int end, Struct[][] minCostTree) {
		if (start == end) {
			return new Struct(arr[start], 0);
		}
		if (minCostTree[start][end] != null) {
			return minCostTree[start][end];
		}
		if (end == start + 1) {
			minCostTree[start][end] = new Struct(Math.max(arr[start], arr[end]), arr[start] * arr[end]);
			return minCostTree[start][end];
		}
		Struct minCost = new Struct(0, Integer.MAX_VALUE);
		for (int i = start; i < end; i++) {
			Struct minCostLeft = mctFromLeafValues(arr, start, i, minCostTree);
			minCostTree[start][i] = minCostLeft;
			Struct minCostRight = mctFromLeafValues(arr, i + 1, end, minCostTree);
			minCostTree[i + 1][end] = minCostRight;
			int minCostSum = minCostRight.minSum + minCostLeft.minSum + minCostLeft.maxValue * minCostRight.maxValue;
			if (minCost.minSum > minCostSum) {
				minCost = new Struct(Math.max(minCostLeft.maxValue, minCostRight.maxValue), minCostSum);
			}
		}
		minCostTree[start][end] = minCost;
		return minCostTree[start][end];
	}

	class Struct {
		int maxValue;
		int minSum;

		public Struct(int maxValue, int minSum) {
			this.maxValue = maxValue;
			this.minSum = minSum;
		}
	}
}
