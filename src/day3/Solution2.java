package day3;

// https://school.programmers.co.kr/learn/courses/30/lessons/60058

import java.util.Deque;
import java.util.ArrayDeque;

class Solution2 {
    public String solution(String p) {
        return solve(p);
    }
    
    String solve(String w) {
        int left = 0;
        int right = 0;
        int splitI = 0;
        
        if (w.length() == 0) {
            return w;
        }
        
        for (int i = 0; i < w.length(); i++) {
            if (w.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            
            if (left > 0 && left == right) {
                splitI = i;
                break;
            }
        }
        
        String u = w.substring(0, splitI + 1);
        String v = w.substring(splitI + 1);
        
        if (isCorrect(u)) {
            return u + solve(v);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            sb.append(solve(v));
            sb.append(")");
            
            for (int i = 1; i < u.length()-1; i++) {
                if (u.charAt(i) == '(') {
                    sb.append(')');
                } else {
                    sb.append('(');
                }
            }
            return sb.toString();
        }
    }
    
    boolean isCorrect(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        
        for (char c: s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
                continue;
            }
            
            if (!stack.isEmpty()) {
                stack.pop();
            } else {
                return false;
            }
        }
        
        if (!stack.isEmpty()) {
            return false;
        }
        
        return true;
    }
}