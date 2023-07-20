package day4;

// https://school.programmers.co.kr/learn/courses/30/lessons/159993

import java.util.Queue;
import java.util.LinkedList;

class Solution7 {
    String[] maps;
    
    public int solution(String[] maps) {
        this.maps = maps;
        int sI = 0;
        int sJ = 0;
        int lI = 0;
        int lJ = 0;
        int eI = 0;
        int eJ = 0;
        
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                char c = maps[i].charAt(j);
                if (c == 'S') {
                    sI = i;
                    sJ = j;
                }
                else if (c == 'E') {
                    eI = i;
                    eJ = j;
                }
                else if (c == 'L') {
                    lI = i;
                    lJ = j;
                }
            }
        }
        
        int leverDist = bfs(sI, sJ, lI, lJ);
        
        if (leverDist == -1) {
            return -1;
        }
        
        int endDist = bfs(lI, lJ, eI, eJ);
        
        if (endDist == -1) {
            return -1;
        }
        
        return leverDist + endDist;
    }
    
    int bfs(int startI, int startJ, int targetI, int targetJ) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] distance = new int[maps.length][maps[0].length()];
        
        for (int i = 0; i < distance.length; i++) {
            for (int j = 0; j < distance[0].length; j++) {
                distance[i][j] = -1;
            }
        }
        
        queue.offer(new int[]{startI, startJ});
        distance[startI][startJ] = 0;
        
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int i = pos[0];
            int j = pos[1];
            
            if (i == targetI && j == targetJ) {
                return distance[i][j];
            }
            
            if (i > 0 && maps[i-1].charAt(j) != 'X' && distance[i-1][j] == -1) {
                distance[i-1][j] = distance[i][j] + 1;
                queue.offer(new int[]{i-1, j});
            }
            if (j > 0 && maps[i].charAt(j-1) != 'X' && distance[i][j-1] == -1) {
                distance[i][j-1] = distance[i][j] + 1;
                queue.offer(new int[]{i, j-1});
            }
            if (i < maps.length-1 && maps[i+1].charAt(j) != 'X' && distance[i+1][j] == -1) {
                distance[i+1][j] = distance[i][j] + 1;
                queue.offer(new int[]{i+1, j});
            }
            if (j < maps[0].length()-1 && maps[i].charAt(j+1) != 'X' && distance[i][j+1] == -1) {
                distance[i][j+1] = distance[i][j] + 1;
                queue.offer(new int[]{i, j+1});
            }
            
        }
        
        return -1;
    }
}