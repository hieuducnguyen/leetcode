/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100inteview.hard;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author hieund3
 */
public class WordBreakII {

	static WordBreakII INSTANCE = new WordBreakII();

	public static void main(String[] args) {
		String s = "catsanddog";
		List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
		List<String> wordBreak = INSTANCE.wordBreak(s, wordDict);
		System.out.println(wordBreak);
	}

	public List<String> wordBreak(String s, List<String> wordDict) {
		
		return null;
	}
}
