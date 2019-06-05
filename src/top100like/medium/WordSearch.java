/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like.medium;

/**
 *
 * @author hieund3
 */
public class WordSearch {

	public static void main(String[] args) {
		char[][] board = new char[][]{{'A', 'B'}};
		String word = "BA";
		boolean exist = process(board, word);
		System.out.println("exist: " + exist);
	}

	private static boolean process(char[][] board, String word) {
		int n = board.length;
		int m = board[0].length;
		for (int j = 0; j < n; j++) {
			for (int i = 0; i < m; i++) {
				if (isExist(j, i, 0, n, m, word, board)) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean isExist(int j, int i, int index, int n, int m, String word, char[][] board) {
		if (index == word.length()) {
			return true;
		}
		if (j < 0 || i < 0 || j >= n || i >= m) {
			return false;
		}
		if (board[j][i] != word.charAt(index)) {
			return false;
		}
		char temp = board[j][i];
		board[j][i] = '-';
		boolean isExist = isExist(j - 1, i, index + 1, n, m, word, board)
			|| isExist(j + 1, i, index + 1, n, m, word, board)
			|| isExist(j, i - 1, index + 1, n, m, word, board)
			|| isExist(j, i + 1, index + 1, n, m, word, board);
		board[j][i] = temp;
		return isExist;
	}
}
