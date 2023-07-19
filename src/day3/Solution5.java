package day3;

// https://school.programmers.co.kr/learn/courses/30/lessons/154538

import java.util.Queue;
import java.util.LinkedList;

class Solution5 {
    public int solution(int x, int y, int n) {
        Queue<int[]> queue = new LinkedList<>();
        
        queue.offer(new int[]{y, 0});
        while (!queue.isEmpty()) {
            int[] q = queue.poll();
            int v = q[0];
            int i = q[1];
            
            if (v < x) {
                continue;
            }
            
            if (v == x) {
                return i;
            }
            
            if (v % 3 == 0) {
                queue.offer(new int[]{v/3, i+1});
            }
            if (v % 2 == 0) {
                queue.offer(new int[]{v/2, i+1});
            }
            queue.offer(new int[]{v-n, i+1});
        }
        
        return -1;
    }
}