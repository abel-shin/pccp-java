package day1;

// https://school.programmers.co.kr/learn/courses/30/lessons/140108

class Solution2 {
    int count = 0;
    
    public int solution(String s) {
        splitString(s);
        return count;
    }
    
    void splitString(String str) {   
        if (str.length() == 0) {
            return;
        }
        
        char x = str.charAt(0);
        
        int numX = 1;
        int numNonX = 0;
        int splitI = -1;
        for (int i = 1; i < str.length(); i++) {
            if (x == str.charAt(i)) {
                numX++;
            } else {
                numNonX++;
            }
            
            if (numX == numNonX) {
                splitI = i;
                break;
            }
        }
        
        count++;
        if (splitI != -1) {
            splitString(str.substring(splitI + 1));
        }
    }
}