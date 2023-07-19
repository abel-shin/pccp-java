package day4;

// https://school.programmers.co.kr/learn/courses/30/lessons/1844

import java.util.Queue;
import java.util.LinkedList;


class Solution3 {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        int[][] distance = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                distance[i][j] = -1;
            }
        }
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        distance[0][0] = 1;
        
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int i = pos[0];
            int j = pos[1];
            
            if (i == n-1 && j == m-1) {
                return distance[i][j];
            }
            
            
            int currDistance = distance[i][j];
            
            if (i > 0 && maps[i-1][j] == 1 && distance[i-1][j] == -1) {
                distance[i-1][j] = currDistance + 1;
                queue.offer(new int[]{i-1, j});
            }
            if (j > 0 && maps[i][j-1] == 1 && distance[i][j-1] == -1) {
                distance[i][j-1] = currDistance + 1;
                queue.offer(new int[]{i, j-1});
            }
            if (i < n-1 && maps[i+1][j] == 1 && distance[i+1][j] == -1) {
                distance[i+1][j] = currDistance + 1;
                queue.offer(new int[]{i+1, j});
            }
            if (j < m-1 && maps[i][j+1] == 1 && distance[i][j+1] == -1) {
                distance[i][j+1] = currDistance + 1;
                queue.offer(new int[]{i, j+1});
            }            
        }

        return -1;
    }
}