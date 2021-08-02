package top100inteview.easy;

/*
 * Created by hieund3 on 09/07/2021
 */
public class _190_ReverseBits {
	public static final _190_ReverseBits INSTANCE = new _190_ReverseBits();

	public int reverseBits(int n) {
		int mask1 = 0xFFFF;
		int n1 = n & mask1;
		int mask2 = 0xFFFF0000;
		int n2 = n & mask2;
		int n12 = n1 << 16 | n2 >>> 16;

		int mask3 = 0xFF00FF;
		int n3 = mask3 & n12;
		int mask4 = 0xFF00FF00;
		int n4 = mask4 & n12;
		int n34 = n3 << 8 | n4 >>> 8;

		int mask5 = 0x0F0F0F0F;
		int mask6 = 0xF0F0F0F0;
		int n5 = n34 & mask5;
		int n6 = n34 & mask6;
		int n56 = n5 << 4 | n6 >>> 4;

		int mask7 = 0x33333333;
		int mask8 = 0xCCCCCCCC;
		int n7 = n56 & mask7;
		int n8 = n56 & mask8;
		int n78 = n7 << 2 | n8 >>> 2;

		int mask9 = 0x55555555;
		int mask10 = 0xAAAAAAAA;
		int n9 = n78 & mask9;
		int n10 = n78 & mask10;
		int n910 = n9 << 1 | n10 >>> 1;

		return n910;
	}

}
