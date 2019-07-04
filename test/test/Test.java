/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author hieund3
 */
public class Test {
	
	public static void main(String[] args) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(1, Integer.MIN_VALUE);
		System.out.println(map.getOrDefault(2, Integer.MAX_VALUE));
	}
}
