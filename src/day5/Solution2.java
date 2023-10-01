package day5;

// https://school.programmers.co.kr/learn/courses/30/lessons/43163

/*
 * 단어를 하나씩 타고 다니면서 변환하는 그래프 문제입니다.
 * 그래프가 아닌 트리 문제로 해석할 경우, 루프가 발생해 무한히 탐색하게 됩니다.
 * 문자가 하나만 다르면 두 문자열은 인접한 노드가 되는 점을 이용해 구현해 봅시다.
 */

class Solution2 {
    String target;
    String[] words;
    int answer = Integer.MAX_VALUE;
 
    public int solution(String begin, String target, String[] words) {
        this.target = target;
        this.words = words;
        
        boolean[] visited = new boolean[words.length]; // 방문한 노드에 재방문하지 않기 위한 visited 배열
        
        dfs(0, 0, begin, visited);
 
        return answer == Integer.MAX_VALUE ? 0 : answer; // 답이 없을 경우 0 반환
    }
 
    void dfs(int idx, int count, String word, boolean[] visited) {
        if (word.equals(target)) { // 타겟에 도달했으면 변환 횟수를 업데이트
            answer = Math.min(answer, count);
            return;
        }
 
        for (int i = 0; i < words.length; i++) { // i번째 문자열이 방문 가능하면 방문 수행
            if (visited[i] || answer <= count || !isAdjacent(word, words[i])) {
                continue;
            }
 
            visited[i] = true; // 방문 여부를 반드시 체크
            dfs(i, count + 1, words[i], visited);
            visited[i] = false;
        }
    }
 
    boolean isAdjacent(String x, String y) { // 한 문자만 다를 경우 인접한 문자열
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