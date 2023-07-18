package day2;

// https://school.programmers.co.kr/learn/courses/30/lessons/43236

import java.util.Arrays;

class Solution6 {
    public int solution(int distance, int[] rocks, int n) {
        int left = 0;
        int right = distance;
        int answer = 0;
        
        Arrays.sort(rocks);
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
             
            int count = 0;
            int lastRock = 0;
            for (int rock: rocks) {
                if (rock - lastRock < mid) {
                    count++;
                } else {
                    lastRock = rock;
                }
            }
            
            if (distance - lastRock < mid) {
                count++;
            }
            
            if (count > n) {
                right = mid - 1;
            } else {
                answer = mid;
                left = mid + 1;
            }
            
        }
        return answer;
    }
}
