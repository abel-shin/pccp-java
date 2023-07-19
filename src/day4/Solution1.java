package day4;

// https://school.programmers.co.kr/learn/courses/30/lessons/49189

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;


class Solution1 {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i < n+1; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] e: edge) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        
        int[] distance = new int[n+1];
        for (int i = 0; i < distance.length; i++) {
            distance[i] = -1;
        }
        
        
        Queue<Integer> queue = new LinkedList<>();
        distance[1] = 0;
        queue.offer(1);
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int adjNode: adj.get(node)) {
                if (distance[adjNode] == -1) {
                    distance[adjNode] = distance[node] + 1;
                    queue.offer(adjNode);
                }
            }
        }

        int maxVal = Arrays.stream(distance).max().getAsInt();        
        return (int)Arrays.stream(distance).filter(x -> x == maxVal).count();
    }
}