package day4;


class Solution2 {
    String target;
    String[] words;
    int answer = Integer.MAX_VALUE;
 
    public int solution(String begin, String target, String[] words) {
        this.target = target;
        this.words = words;
        
        boolean[] visited = new boolean[words.length];
        
        dfs(0, 0, begin, visited);
 
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
 
    void dfs(int idx, int count, String word, boolean[] visited) {
        if (idx >= words.length) {
            return;
        }
 
        if (word.equals(target)) {
            answer = Math.min(answer, count);
            return;
        }
 
        for (int i = 0; i < words.length; i++) {
            if (visited[i] || answer <= count || !isAdjacent(word, words[i])) {
                continue;
            }
 
            visited[i] = true;
            dfs(i, count + 1, words[i], visited);
            visited[i] = false;
        }
    }
 
    boolean isAdjacent(String x, String y) {
        int count = 0;
        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) != y.charAt(i)) {
                count++;
 
                if (count >= 2) {
                    return false;
                }
            }
        }
 
        return true;
    }
}