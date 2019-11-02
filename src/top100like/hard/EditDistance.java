/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like.hard;

/**
 *
 * @author hieund3
 */
public class EditDistance {

	public static final EditDistance INSTANCE = new EditDistance();

	public static void main(String[] args) {
		String word2 = "logicochaeo";
		String word1 = "psycho";
//		String word1 = "hello";
//		String word2 = "ll";
		int minDistance = INSTANCE.minDistanceV2(word1, word2);
		System.out.println("minDistance: " + minDistance);
	}

	public int minDistance(String word1, String word2) {
		if (word1.isEmpty() || word2.isEmpty()) {
			return Math.max(word1.length(), word2.length());
		}
		if (word1.equals(word2)) {
			return 0;
		}
		if (word1.charAt(0) == word2.charAt(0)) {
			return minDistance(word1.substring(1), word2.substring(1));
		} else {
			int minDistanceReplace = minDistance(word1.substring(1), word2.substring(1));
			int minDistanceInsertOrRemove = Math.min(minDistance(word1, word2.substring(1)),
				minDistance(word1.substring(1), word2));
			return Math.min(minDistanceReplace, minDistanceInsertOrRemove) + 1;
		}
	}

	private int minDistanceV2(String word1, String word2) {
		final int maxLen = Math.max(word1.length(), word2.length());
		if (word1.isEmpty() || word2.isEmpty()) {
			return maxLen;
		}
		if (word1.equals(word2)) {
			return 0;
		}
		boolean[] dupHorizontal = new boolean[word2.length()];
		int[][] editDistance = new int[word1.length()][word2.length()];
		for (int i = 0; i < word1.length(); i++) {
			boolean dup = false;
			for (int j = 0; j < word2.length(); j++) {
				int leftIndex = i - 1 >= 0 ? editDistance[i - 1][j] : Integer.MAX_VALUE;
				if (word1.charAt(i) == word2.charAt(j) && dupHorizontal[j]) {
					leftIndex++;
				}
				final int leftBottomIndex = i - 1 >= 0 && j - 1 >= 0 ? editDistance[i - 1][j - 1] : Integer.MAX_VALUE;
				int bottom = j - 1 >= 0 ? editDistance[i][j - 1] : Integer.MAX_VALUE;
				if (word1.charAt(i) == word2.charAt(j) && dup) {
					bottom++;
				}
				int value = Math.min(Math.min(leftIndex, leftBottomIndex), bottom);
				value = value == Integer.MAX_VALUE ? 0 : value;
				if (word1.charAt(i) == word2.charAt(j)) {
					editDistance[i][j] = value;
					dup = true;
					dupHorizontal[j] = true;
				} else {
					editDistance[i][j] = value + 1;
				}
			}
		}
//		basic.BasicTest.printMatrix(editDistance);
		return editDistance[word1.length() - 1][word2.length() - 1];
	}
}
