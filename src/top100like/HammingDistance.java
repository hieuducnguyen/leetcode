/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like;

/**
 *
 * @author HieuDucNguyen
 */
public class HammingDistance {

    public static void main(String[] args) {
        int x = 9;
        int y = 10;
        int result = process(x, y);
        System.out.println("result: " + result);
    }

    private static int process(int x, int y) {
        int z = x ^ y;
        int num1Bit = count(z);
        return num1Bit;
    }

    private static int count(int z) {
        int count = 0;
        for (int i = 1; i < 33; i++) {
            if (is1Bit(z, i)) {
                count++;
            }
        }
        return count;
    }

    private static boolean is1Bit(int z, int i) {
        return (z&(1<<i)) != 0;
    }

}
