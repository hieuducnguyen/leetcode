package dynamicprogramming;

/*
 * Created by hieund3 on 19/06/2021
 */
public class _746_MinCostClimbingStairs {
	public static final _746_MinCostClimbingStairs INSTANCE = new _746_MinCostClimbingStairs();

	public int minCostClimbingStairs(int[] cost) {
		if (cost == null || cost.length < 2) {
			return 0;
		}
		int[] minCost = new int[cost.length + 1];
		minCost[0] = 0;
		minCost[1] = 0;
		for (int i = 2; i < minCost.length; i++) {
			minCost[i] = Math.min(minCost[i - 1] + cost[i - 1], minCost[i - 2] + cost[i - 2]);
		}
		return minCost[minCost.length - 1];
	}
}
