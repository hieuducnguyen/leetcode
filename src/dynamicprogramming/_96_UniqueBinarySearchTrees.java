package dynamicprogramming;

/*
 * Created by hieund3 on 23/06/2021
 */
public class _96_UniqueBinarySearchTrees {
	public static final _96_UniqueBinarySearchTrees INSTANCE = new _96_UniqueBinarySearchTrees();

	public int numTrees(int n) {
		int[] numTrees = new int[n + 1];
		numTrees[0] = 1;
		numTrees[1] = 1;
		for (int i = 2; i <= n; i++) {
			int numTree = 0;
			for (int j = 0; j < i; j++) {
				numTree += numTrees[j] * numTrees[i - 1 - j];
			}
			numTrees[i] = numTree;
		}
		return numTrees[n];
	}
}
