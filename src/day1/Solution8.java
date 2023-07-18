package day1;

import java.util.List;
import java.util.ArrayList;

// https://school.programmers.co.kr/learn/courses/30/lessons/12910

class Solution8 {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();
        for (int val: arr) {
            if (val % divisor == 0) {
                list.add(val);
            }
        }
        
        int[] answer = list.stream().sorted().mapToInt(i->i).toArray();
        return answer.length > 0 ? answer : new int[]{-1};
    }
}