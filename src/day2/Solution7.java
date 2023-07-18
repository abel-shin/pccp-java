package day2;

// https://school.programmers.co.kr/learn/courses/30/lessons/12909

import java.util.Deque;
import java.util.ArrayDeque;

class Solution7 {
    boolean solution(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        
        Deque<Character> stack = new ArrayDeque<>();
        
        for (char c: s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        
        if (stack.isEmpty()) {
            return true;
        }
        
        return false;
    }
}