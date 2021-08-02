package slidingwindow;

/*
 * Created by hieund3 on 11/07/2021
 */
public class LongestSubStringWithKDistance {
	public static final LongestSubStringWithKDistance INSTANCE = new LongestSubStringWithKDistance();

	public int longest(char[] arr, int k) {
		int[] frequence = new int[26];
		int longestSubString = 0, startWindow = 0, distinctChar = 0;
		for (int i = 0; i < arr.length; i++) {
			final int charElement = arr[i] - 'a';
			if (frequence[charElement] == 0) {
				distinctChar++;
			}
			frequence[charElement]++;
			while (distinctChar > k) {
				final int startElement = arr[startWindow] - 'a';
				frequence[startElement]--;
				if (frequence[startElement] == 0) {
					distinctChar--;
				}
				startWindow++;
			}
			if (distinctChar == k) {
				longestSubString = Math.max(longestSubString, i - startWindow + 1);
			}
		}
		return longestSubString;
	}
}
