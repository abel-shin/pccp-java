package day4;

// https://school.programmers.co.kr/learn/courses/30/lessons/132265

import java.util.Map;
import java.util.HashMap;


class Solution6 {
    public int solution(int[] topping) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        
        for (int i = 0; i < topping.length; i++) {
            if (!map2.containsKey(topping[i])) {
                map2.put(topping[i], 0);
            }
            map2.put(topping[i], map2.get(topping[i]) + 1);
        }
        
        int answer = 0;
        
        for (int i = 0; i < topping.length - 1; i++) {
            if (!map1.containsKey(topping[i])) {
                map1.put(topping[i], 0);
            }
            map1.put(topping[i], map1.get(topping[i]) + 1);
            
            if (map2.get(topping[i]) == 1) {
                map2.remove(topping[i]);
            } else {
                map2.put(topping[i], map2.get(topping[i]) - 1);
            }
            
            if (map1.keySet().size() == map2.keySet().size()) {
                answer++;
            }
        }
        
        return answer;
    }
}