package day2;

// https://school.programmers.co.kr/learn/courses/30/lessons/42586

import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;


class Solution9 {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < speeds.length; i++) {
            double remain = (100 - progresses[i]) / (double) speeds[i];
            int date = (int) Math.ceil(remain);

            if (!queue.isEmpty() && queue.peek() < date) {
                answer.add(queue.size());
                queue.clear();
            }

            queue.offer(date);
        }
        answer.add(queue.size());

        return answer.stream().mapToInt(i->i).toArray();
    }
}