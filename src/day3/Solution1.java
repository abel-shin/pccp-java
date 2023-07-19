package day3;

// https://school.programmers.co.kr/learn/courses/30/lessons/12946

import java.util.List;
import java.util.ArrayList;

class Solution1 {
    public int[][] solution(int n) {
        List<int[]> result = hanoi(1, 3, 2, n);
        return result.stream().toArray(int[][]::new);
    }
    
    List<int[]> hanoi(int start, int end, int support, int n) {
        if (n == 1) {
            List<int[]> result = new ArrayList<>();
            result.add(new int[]{start, end});
            return result;
        }
        
        List<int[]> result = hanoi(start, support, end, n-1);
        result.add(new int[]{start, end});
        result.addAll(hanoi(support, end, start, n-1));
        return result;        
    }
}