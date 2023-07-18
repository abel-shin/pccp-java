package day1;

// https://school.programmers.co.kr/learn/courses/30/lessons/120921

class Solution1 {
    public int solution(String A, String B) {
        if (A.equals(B)) {
            return 0;
        }
                
        int N = A.length();
        for (int i = 1; i < N; i++) {
            boolean isEqual = true;
            for (int j = 0; j < N; j++) {
                if(A.charAt(j) != B.charAt((i+j)%N)) {
                    isEqual = false;
                }
            }
            if (isEqual) {
                return i;
            }
        }
        
        return -1;
    }
}