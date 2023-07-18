package day2;

// https://school.programmers.co.kr/learn/courses/30/lessons/42587

import java.util.Queue;
import java.util.LinkedList;


class Solution10 {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
 
        for (int i = 0; i < priorities.length; i++) {
            queue.add(priorities[i]);
        }
        
        while (!queue.isEmpty()) {
            int max = 0;
 
            for (int val : queue) {
                if (val > max) {
                    max = val;
                }
            }
 
            if (queue.peek() >= max) {
                answer++;
                
                if (location == 0) {
                    break;
                } else {
                    queue.poll();
                    location--;
                }
            } else {
                queue.add(queue.peek());
                queue.poll();
 
                if (location == 0) {
                    location = queue.size() - 1;
                } else {
                    location--;
                }
            }
        }
 
        return answer;
    }
}
