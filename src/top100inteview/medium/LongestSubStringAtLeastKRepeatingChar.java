/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100inteview.medium;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author hieund3
 */
public class LongestSubStringAtLeastKRepeatingChar {

	public static final LongestSubStringAtLeastKRepeatingChar Instance = new LongestSubStringAtLeastKRepeatingChar();

	public static void main(String[] args) {
		int ret = Instance.longestSubstring2("bbaaacbd", 3);
		System.out.println(ret);
	}

	private int longestSubstring2(String text, int k) {
		if (text == null || text.isEmpty()) {
			return 0;
		}
		int result = 0;
		for (int i = 1; i <= 26; i++) {
			result = Math.max(longestSubstringWithUniqueCharacter(text, k, i), result);
		}
		return result;
	}

	private int longestSubstringWithUniqueCharacter(String text, int k, int numUniqueChar) {
		int start = 0, end = 0, result = 0, preStart = 0, preEnd = 0;
		Map<Character, Integer> map = new HashMap<>();
		map.put(text.charAt(0), 1);
		while (end < text.length() && start <= end) {
			if (end != preEnd) {
				map.merge(text.charAt(end), 1, (t, v) -> (t + v));
				preEnd = end;
			} else if (start != preStart) {
				Integer frequence = map.get(text.charAt(preStart));
				if (frequence == 1) {
					map.remove(text.charAt(preStart));
				} else {
					map.put(text.charAt(preStart), frequence - 1);
				}
				preStart = start;
			}
			if (map.size() == numUniqueChar) {
				int satisfiedFrequency = 0;
				for (Integer frequency : map.values()) {
					if (frequency >= k) {
						satisfiedFrequency++;
					}
				}
				if (satisfiedFrequency == map.values().size()) {
					result = Math.max(end - start + 1, result);
				}
				end++;
			} else if (map.size() < numUniqueChar) {
				end++;
			} else {
				start++;
			}
		}
		return result;
	}

	public int longestSubstring(String s, int k) {
		int d = 0;

		for (int numUniqueTarget = 1; numUniqueTarget <= 26; numUniqueTarget++) {
			d = Math.max(d, longestSubstringWithNUniqueChars(s, k, numUniqueTarget));
		}

		return d;
	}

	private int longestSubstringWithNUniqueChars(String s, int k, int numUniqueTarget) {
		int[] map = new int[128];
		int numUnique = 0; // counter 1
		int numNoLessThanK = 0; // counter 2
		int begin = 0, end = 0;
		int d = 0;

		while (end < s.length()) {
			if (map[s.charAt(end)]++ == 0) {
				numUnique++; // increment map[c] after this statement
			}
			if (map[s.charAt(end++)] == k) {
				numNoLessThanK++; // inc end after this statement
			}
			while (numUnique > numUniqueTarget) {
				if (map[s.charAt(begin)]-- == k) {
					numNoLessThanK--; // decrement map[c] after this statement
				}
				if (map[s.charAt(begin++)] == 0) {
					numUnique--; // inc begin after this statement
				}
			}

			// if we found a string where the number of unique chars equals our target
			// and all those chars are repeated at least K times then update max
			if (numUnique == numUniqueTarget && numUnique == numNoLessThanK) {
				d = Math.max(end - begin, d);
			}
		}
		return d;
	}
}
