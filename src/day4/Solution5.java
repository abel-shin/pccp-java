package day4;

// https://school.programmers.co.kr/learn/courses/30/lessons/70129

class Solution5 {
    public int[] solution(String s) {
        int transCount = 0;
        int zeroCount = 0;
        
        while (!s.equals("1")) {
            int oneCount = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    oneCount++;
                } else {
                    zeroCount++;
                }
            }
            
            s = Integer.toBinaryString(oneCount);
            transCount++;
        }
        
        return new int[]{transCount, zeroCount};
    }
}