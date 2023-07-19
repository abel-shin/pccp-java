package day3;

// https://school.programmers.co.kr/learn/courses/30/lessons/43165

class Solution4 {
    int[] numbers;
    int target;
    int count = 0;
    
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        dfs(-1, 0);
        return count;
    }
    
    void dfs(int i, int value) {
        if (i == numbers.length - 1) {
            if (value == target) {
                count++;
            }
            return;
        }
        
        dfs(i+1, value + numbers[i+1]);
        dfs(i+1, value - numbers[i+1]);
    }
}