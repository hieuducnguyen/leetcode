/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100inteview.easy;

/**
 *
 * @author hieund3
 */
public class ReverseBits {

	public static final ReverseBits Instance = new ReverseBits();

	public static void main(String[] args) {
		int reverseBits = Instance.reverseBits2(5);
		System.out.println(reverseBits);
	}

	public int reverseBits(int n) {
		int value = 0;
		for (int i = 0; i < 32; i++) {
			value = value << 1 | n & 1;
			n = n >> 1;
		}
		return value;
	}

	public int reverseBits2(int n) {
		n = (n >>> 16) | (n << 16);
		n = (n & 0xFF00FF00) >>> 8 | (n & 0x00FF00FF) << 8;
		n = (n & 0xF0F0F0F0) >>> 4 | (n & 0x0F0F0F0F) << 4;
		n = (n & 0xCCCCCCCC) >>> 2 | (n & 0x33333333) << 2;
		n = (n & 0xAAAAAAAA) >>> 1 | (n & 0x55555555) << 1;
		return n;
	}
}
