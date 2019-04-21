/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HieuDucNguyen
 */
public class FindAllNumDissaperInList {

    public static void main(String[] args) {
        int[] inputList = new int[]{1, 4};
        List<Integer> list = proccess(inputList);
        System.out.println("list: " + list);
    }

    private static List<Integer> proccess(int[] inputList) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= inputList.length; i++) {
            list.add(i);
        }
        for (int i = 0; i < inputList.length; i++) {
            list.remove((Integer) inputList[i]);
        }
        return list;
    }
}
