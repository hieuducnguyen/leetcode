package dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/*
 * Created by hieund3 on 27/07/2021
 */
public class _983_MinimumCostForTickets {
	public static final _983_MinimumCostForTickets INSTANCE = new _983_MinimumCostForTickets();

	public int mincostTickets(int[] days, int[] costs) {
		Map<Integer, Integer> minCostMap = new HashMap<>();
		minCostMap.put(days[0], Math.min(Math.min(costs[0], costs[1]), costs[2]));
		for (int i = 1; i < days.length; i++) {
			int minCost = costs[0] + minCostMap.get(days[i - 1]);
			int visit7day = 0, visit30days = 0;
			for (int j = 1; j < 30; j++) {
				if (minCostMap.containsKey(days[i] - j)) {
					if (j < 7) {
						visit7day++;
					}
					visit30days++;
				}
			}
			int minCostVisit7Days = i - visit7day - 1 >= 0 ? costs[1] + minCostMap.get(days[i - visit7day - 1])
				: costs[1];
			int minCostVisit30Days = i - visit30days - 1 >= 0 ? costs[2] + minCostMap.get(days[i - visit30days - 1])
				: costs[2];
			minCost = Math.min(minCostVisit7Days, minCost);
			minCost = Math.min(minCostVisit30Days, minCost);
			minCostMap.put(days[i], minCost);
		}
		return minCostMap.get(days[days.length - 1]);
	}
}
