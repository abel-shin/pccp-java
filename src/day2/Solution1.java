package day2;

// https://school.programmers.co.kr/learn/courses/30/lessons/12915

import java.util.Arrays;

class Solution1 {
    public String[] solution(String[] strings, int n) {
        return Arrays.stream(strings).
                sorted((a, b) -> {
                    if (a.charAt(n) == b.charAt(n)) {
                        return a.compareTo(b);
                    }
                    return a.charAt(n) - b.charAt(n);
                }).toArray(String[]::new);
    }
}