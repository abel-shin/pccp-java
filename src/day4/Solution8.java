package day4;

// https://school.programmers.co.kr/learn/courses/30/lessons/92343

import java.util.Set;
import java.util.HashSet;

class Solution8 {
    int[] info;
    Set<Integer>[] adj;
    int answer = 0;
    
    public int solution(int[] info, int[][] edges) {
        this.info = info;
        this.adj = new Set[info.length];
        
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new HashSet<>();
        }
        
        for (int[] e: edges) {
            adj[e[0]].add(e[1]);
        }
        
        Set<Integer> children = new HashSet<>();
        for (int child: adj[0]) {
            children.add(child);
        }
        
        dfs(0, 0, 0, children);
        
        return answer;
    }
    
    void dfs(int curr, int sheep, int wolf, Set<Integer> children) {
        if (info[curr] == 0) {
            sheep += 1;
        } else {
            wolf += 1;
        }
        
        if (sheep <= wolf) {
            return;
        }
        
        answer = Math.max(answer, sheep);
        
        for (int child: adj[curr]) {
            children.add(child);
        }
        
        Set<Integer> childrenCopy = new HashSet<>(children);
        for (int child: childrenCopy) {
            children.remove(child);
            dfs(child, sheep, wolf, children);
            children.add(child);
        }
        
        for (int child: adj[curr]) {
            children.remove(child);
        }
    }
}