package slidingwindow;

import java.util.HashMap;
import java.util.Map;

/*
 * Created by hieund3 on 15/07/2021
 */
public class LongestSubstringWithAtMostTwoDistinctCharacters {
	public static final LongestSubstringWithAtMostTwoDistinctCharacters INSTANCE =
		new LongestSubstringWithAtMostTwoDistinctCharacters();

	public int lengthOfLongestSubstringTwoDistinct(String s) {
		if (s == null || s.isEmpty()) {
			return 0;
		}
		Map<Character, Integer> frequence = new HashMap<>();
		int startWindow = 0, endWindow = 0, len = Integer.MIN_VALUE, counter = 0;
		while (endWindow < s.length()) {
			final char charElement = s.charAt(endWindow);
			frequence.put(charElement, frequence.getOrDefault(charElement, 0) + 1);
			if (frequence.get(charElement) == 1) {
				counter++;
			} else {
				counter--;
			}
			while (counter > 2) {
				final char c = s.charAt(startWindow);
				frequence.put(c, frequence.get(c) - 1);
				if (frequence.get(c) == 1) {
					counter++;
				}
				startWindow++;
			}
			len = Math.max(len, endWindow - startWindow + 1);
			endWindow++;
		}
		return len;
	}
}
