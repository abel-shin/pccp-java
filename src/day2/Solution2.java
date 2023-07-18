package day2;

// https://school.programmers.co.kr/learn/courses/30/lessons/42746

import java.util.Arrays;

class Solution2 {
    public String solution(int[] numbers) {
        String[] nums = Arrays.stream(numbers)
                            .boxed()
                            .map(i->String.valueOf(i))
                            .sorted((a, b) -> {
                                int x = Integer.valueOf(a+b);
                                int y = Integer.valueOf(b+a);
                                return y - x;                                    
                            }).toArray(String[]::new);
        
        String answer = String.join("", nums);
        return answer.charAt(0) == '0' ? "0" : answer;
    }
}