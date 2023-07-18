package day2;

// https://school.programmers.co.kr/learn/courses/30/lessons/43238

import java.util.Arrays;

class Solution5 {
    public long solution(int n, int[] times) {
        long left = 0;
        long right = (long)Arrays.stream(times).min().getAsInt() * n;
        
        
        while (left < right) {
            long mid = left + (right - left) / 2; 
            
            long total = 0;
            for (int time: times) {
                total += mid / time;
            }
            
            if (total >= n) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return right;
    }
}