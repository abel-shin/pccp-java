package day4;

// https://school.programmers.co.kr/learn/courses/30/lessons/12935

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;


class Solution4 {
    public int[] solution(int[] arr) {
        int minVal = Arrays.stream(arr).min().getAsInt();
        
        List<Integer> list = new ArrayList<>();
        
        for (int val: arr) {
            if (val != minVal) {
                list.add(val);
            }
        }
        
        return list.size() == 0 ? new int[]{-1} : list.stream().mapToInt(i->i).toArray();
    }
}