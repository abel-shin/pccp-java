package day1;

// https://school.programmers.co.kr/learn/courses/30/lessons/64061

import java.util.List;
import java.util.ArrayList;

class Solution7 {
    public int solution(int[][] board, int[] moves) {
        List<Integer> stack = new ArrayList<>();
        
        int count = 0;
        for (int move: moves) {
            int j = move - 1;
            int doll = -1;
            for (int i = 0; i < board.length; i++) {
                if (board[i][j] != 0) {
                    doll = board[i][j];
                    board[i][j] = 0;
                    break;
                }
            }
            
            if (doll == -1) {
                continue;
            }
            
            if (!stack.isEmpty() && stack.get(stack.size() - 1) == doll) {
                stack.remove(stack.size() - 1);
                count += 2;
            } else {
                stack.add(doll);
            }
        }
        
        return count;
    }
}