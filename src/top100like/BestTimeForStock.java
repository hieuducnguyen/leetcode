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
public class BestTimeForStock {

    public static int process(int[] array) {
        if (array == null || array.length == 0 || array.length == 1) {
            return 0;
        }
        final int len = array.length;
        int[] maxValue = new int[len];
        maxValue[len - 1] = array[len - 1];
        int maxProfit = 0;
        for (int i = (len - 2); i >= 0; i--) {
            maxProfit = Math.max(maxProfit, (maxValue[i + 1] - array[i]));
            maxValue[i] = Math.max(maxValue[i + 1], array[i]);
        }
        return maxProfit;
    }

    public static int process2(int[] array) {
        if (array == null || array.length == 0 || array.length == 1) {
            return 0;
        }
        final int len = array.length;
        int max = array[len - 1];
        int maxProfit = 0;
        for (int i = (len - 2); i >= 0; i--) {
            maxProfit = Math.max(max - array[i], maxProfit);
            max = Math.max(max, array[i]);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] a = new int[]{7, 6, 4, 8, 1};
        int maxProfit = process2(a);
        System.out.println("maxProfit: " + maxProfit);
    }
}
