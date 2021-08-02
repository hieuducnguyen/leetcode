package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * Created by hieund3 on 20/07/2021
 */
public class _646_MaximumLengthofPairChain {
	public static final _646_MaximumLengthofPairChain INSTANCE = new _646_MaximumLengthofPairChain();

	public int findLongestChain(int[][] pairs) {
		if (pairs == null || pairs.length == 0) {
			return 0;
		}
		Arrays.sort(pairs, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				} else {
					return o1[0] - o2[0];
				}
			}
		});
		List<int[]> longestPairList = new ArrayList<>();
		longestPairList.add(pairs[0]);
		for (int i = 1; i < pairs.length; i++) {
			if (longestPairList.get(longestPairList.size() - 1)[1] < pairs[i][0]) {
				longestPairList.add(pairs[i]);
			} else if (longestPairList.get(longestPairList.size() - 1)[1] > pairs[i][0]
				&& longestPairList.get(longestPairList.size() - 1)[1] > pairs[i][1]) {
				longestPairList.set(longestPairList.size() - 1, pairs[i]);
			}
		}
		return longestPairList.size();
	}
}
