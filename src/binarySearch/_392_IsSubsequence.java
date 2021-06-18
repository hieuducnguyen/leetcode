package binarySearch;

/*
 * Created by hieund3 on 15/06/2021
 */
public class _392_IsSubsequence {
	public static final _392_IsSubsequence INSTANCE = new _392_IsSubsequence();

	public boolean isSubsequence(String s, String t) {
		final char[] subSequenceArr = s.toCharArray();
		final char[] charArr = t.toCharArray();
		int walkerSubSequence = 0, walkerCharArr = 0;
		final int subSequenceLen = subSequenceArr.length;
		final int charArrLen = charArr.length;
		while ((walkerSubSequence < subSequenceLen) && (walkerCharArr < charArrLen)) {
			if (subSequenceArr[walkerSubSequence] == charArr[walkerCharArr]) {
				walkerSubSequence++;
			}
			walkerCharArr++;
		}
		return walkerSubSequence == subSequenceLen;
	}
}
