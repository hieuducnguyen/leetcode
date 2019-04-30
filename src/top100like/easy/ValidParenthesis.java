/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package top100like.easy;

import java.util.HashMap;
import java.util.Objects;
import java.util.Stack;

/**
 *
 * @author HieuDucNguyen
 */
public class ValidParenthesis {

    private static boolean process(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        if (s.length() % 2 == 1) {
            return false;
        }
        HashMap<Character, Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('[', ']');
        map.put('(', ')');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char charItem = s.charAt(i);
            if (map.containsKey(charItem)) {
                stack.push(charItem);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character value = stack.pop();
                if (!Objects.equals(charItem, map.get(value))) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "((";
        boolean ret = process(s);
        System.out.println("ret: " + ret);
    }

}
