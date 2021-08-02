package dynamicprogramming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/*
 * Created by hieund3 on 22/07/2021
 */
public class _1048_LongestStringChain {
	public static final _1048_LongestStringChain INSTANCE = new _1048_LongestStringChain();

	public int longestStrChain(String[] words) {
		if (words == null || words.length == 0) {
			return 0;
		}
		final Map<String, Integer> longestChainMap = new HashMap<>();
		Arrays.sort(words, Comparator.comparingInt(String::length));
		int result = Integer.MIN_VALUE;
		for (String word : words) {
			int longestChain = 0;
			for (int i = 0; i < word.length(); i++) {
				String predecessor = word.substring(0, i) + word.substring(i + 1);
				longestChain = Math.max(longestChainMap.getOrDefault(predecessor, 0) + 1, longestChain);
			}
			longestChainMap.put(word, longestChain);
			result = Math.max(result, longestChain);
		}
		return result;
	}

	public int longestStrChain1(String[] words) {
		Arrays.sort(words, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		});
		int[] longestChainArr = new int[words.length];
		for (int i = 0; i < words.length; i++) {
			longestChainArr[i] = 1;
			int j = i - 1;
			while (j >= 0) {
				if (words[j].length() == words[i].length() - 1) {
					if (isPredecessor(words[j], words[i])) {
						longestChainArr[i] = Math.max(longestChainArr[j] + 1, longestChainArr[i]);
					}
				} else if (words[j].length() != words[i].length()) {
					break;
				}
				j--;
			}
		}
		int longestChain = Integer.MIN_VALUE;
		for (int i : longestChainArr) {
			longestChain = Math.max(longestChain, i);
		}
		return longestChain;
	}

	boolean isPredecessor(String subText, String text) {
		int i = 0, j = 0;
		while (i < subText.length() && j < text.length()) {
			if (subText.charAt(i) == text.charAt(j)) {
				i++;
				j++;
			} else {
				j++;
			}
		}
		return j - i <= 1;
	}
}
