/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author hieund3
 */
public class SpiralMatrix {

	public static void main(String[] args) {
		SpiralMatrix instance = new SpiralMatrix();
		int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
//		int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		List<Integer> result = instance.spiralOrder1(matrix);
		System.out.println(result);
	}

	private List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<>();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return result;
		}
		int[][] visited = new int[matrix.length][matrix[0].length];
		Queue<int[]> direction = new LinkedList<>();
		direction.add(new int[]{1, 0});
		direction.add(new int[]{0, -1});
		direction.add(new int[]{-1, 0});
		direction.add(new int[]{0, 1});

		result.add(matrix[0][0]);
		visited[0][0] = 1;
		int[] move = {0, 1};
		int[] pos = {0, 0};
		do {
			while (canMove(pos[0] + move[0], pos[1] + move[1], visited)) {
				pos[0] += move[0];
				pos[1] += move[1];
				visited[pos[0]][pos[1]] = 1;
				result.add(matrix[pos[0]][pos[1]]);
			}
		} while ((move = getDirection(pos, direction, visited)) != null);
		return result;
	}

	int[] getDirection(int[] pos, Queue<int[]> direction, int[][] visted) {
		for (int i = 0; i < 4; i++) {
			int[] move = direction.poll();
			direction.add(move);
			if (canMove(pos[0] + move[0], pos[1] + move[1], visted)) {
				return move;
			}
		}
		return null;
	}

	private boolean canMove(int x, int y, int[][] visited) {
		if (x >= 0 && x <= visited.length - 1 && y >= 0 && y <= visited[0].length - 1) {
			return visited[x][y] == 0;
		}
		return false;
	}

	public List<Integer> spiralOrder1(int[][] matrix) {
		List<Integer> result = new ArrayList<>();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return result;
		}
		int R = matrix.length, C = matrix[0].length;
		int[] dr = {0, 1, 0, -1};
		int[] dc = {1, 0, -1, 0};
		int r = 0;
		int c = -1;
		int di = 0;
		boolean[][] visited = new boolean[R][C];
		for (int i = 0; i < R * C; i++) {
			int newR = dr[di] + r;
			int newC = dc[di] + c;
			if (0 <= newR && newR <= R - 1 && 0 <= newC && newC <= C - 1 && !visited[newR][newC]) {
				r = newR;
				c = newC;
			} else {
				di = (di + 1) % 4;
				r += dr[di];
				c += dc[di];
			}
			visited[r][c] = true;
			result.add(matrix[r][c]);
		}
		return result;
	}

}
