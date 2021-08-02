package slidingwindow;

/*
 * Created by hieund3 on 18/07/2021
 */
public class _1208_GetEqualSubstringsWithinBudget {
	public static final _1208_GetEqualSubstringsWithinBudget INSTANCE = new _1208_GetEqualSubstringsWithinBudget();

	public int equalSubstring(String s, String t, int maxCost) {
		if (s == null || s.length() == 0 || t == null || t.length() == 0) {
			return 0;
		}
		int startWindow = 0, endWindow = 0, counter = maxCost, maxSubString = Integer.MIN_VALUE;
		while (endWindow < s.length()) {
			int cost = Math.abs(s.charAt(endWindow) - t.charAt(endWindow));
			counter -= cost;
			while (counter < 0) {
				int returnCost = Math.abs(s.charAt(startWindow) - t.charAt(startWindow));
				counter += returnCost;
				startWindow++;
			}
			maxSubString = Math.max(maxSubString, endWindow - startWindow + 1);
			endWindow++;
		}
		return maxSubString;
	}
}
