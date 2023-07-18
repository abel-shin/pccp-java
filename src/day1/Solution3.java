package day1;

// https://school.programmers.co.kr/learn/courses/30/lessons/42576

import java.util.Map;
import java.util.HashMap;


class Solution3 {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> partMap = new HashMap<>();
        Map<String, Integer> compMap = new HashMap<>();
        
        for (String s: participant) {
            if (!partMap.containsKey(s)) {
                partMap.put(s, 0);
            }
            partMap.put(s, partMap.get(s) + 1);
        }
        
        for (String s: completion) {
            if (!compMap.containsKey(s)) {
                compMap.put(s, 0);
            }
            compMap.put(s, compMap.get(s) + 1);
        }
        
        for (String s: partMap.keySet()) {
            if (!compMap.containsKey(s) || 
                !partMap.get(s).equals(compMap.get(s))) {
                return s;
            }
        }
        
        return "";
    }
}
