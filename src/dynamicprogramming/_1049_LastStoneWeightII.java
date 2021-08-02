package dynamicprogramming;

/*
 * Created by hieund3 on 23/07/2021
 */
public class _1049_LastStoneWeightII {
	public static final _1049_LastStoneWeightII INSTANCE = new _1049_LastStoneWeightII();

	public int lastStoneWeightII(int[] stones) {
		if (stones == null || stones.length == 0) {
			return 0;
		}
		if (stones.length == 1) {
			return stones[0];
		}
		int sumWeight = 0, maxWeigth = Integer.MIN_VALUE;
		for (int stone : stones) {
			sumWeight += stone;
			maxWeigth = Math.max(maxWeigth, stone);
		}
		int sizeWeightArr = sumWeight / 2 + maxWeigth;
		boolean[] weightArr = new boolean[sizeWeightArr + 1];
		weightArr[0] = true;
		for (int i = 0; i < stones.length; i++) {
			for (int j = sizeWeightArr; j >= stones[i]; j--) {
				weightArr[j] = weightArr[j] | weightArr[j - stones[i]];
			}
		}
		for (int i = sumWeight / 2; i < sizeWeightArr + 1; i++) {
			if (weightArr[i]) {
				return Math.abs(i - (sumWeight - i));
			}
		}
		return -1;
	}
}
