package dynamicprogramming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * Created by hieund3 on 24/07/2021
 */
public class _354_RussianDollEnvelopes {
	public static final _354_RussianDollEnvelopes INSTANCE = new _354_RussianDollEnvelopes();

	public int maxEnvelopes(int[][] envelopes) {
		if (envelopes == null || envelopes.length == 0) {
			return 0;
		}
		Arrays.sort(envelopes, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] != o2[0]) {
					return o1[0] - o2[0];
				} else {
					return o2[1] - o1[1];
				}
			}
		});
		int[] maxEnvelopeArr = new int[envelopes.length];
		int maxEnvelopes = Integer.MIN_VALUE;
		for (int i = 0; i < envelopes.length; i++) {
			maxEnvelopeArr[i] = 1;
			for (int j = 0; j < i; j++) {
				if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
					maxEnvelopeArr[i] = Math.max(maxEnvelopeArr[i], maxEnvelopeArr[j] + 1);
				}
			}
			maxEnvelopes = Math.max(maxEnvelopes, maxEnvelopeArr[i]);
		}
		return maxEnvelopes;
	}

	private int binSearch(List<int[]> maxEnvelopesList, int[][] envelopes) {
		int l = 0, r = maxEnvelopesList.size(), m;
		while (l < r) {
			m = (l + r) / 2;
			if (envelopes[m][0] == envelopes[l][0]) {
				if (envelopes[m][1] == envelopes[l][1]) {
					return Integer.MAX_VALUE;
				} else if (envelopes[m][1] > envelopes[l][1]) {
					return Integer.MAX_VALUE;
				} else {
					return -m;
				}
			} else if (envelopes[m][0] > envelopes[l][0]) {
				l = m + 1;
			} else {
				r = m;
			}
		}
		return l;
	}
}
