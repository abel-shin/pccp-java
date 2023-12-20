// https://school.programmers.co.kr/learn/courses/30/lessons/42626

// 가장 맵지 않은 음식과 두 번째로 맵지 않은 음식을 빠르게 찾는 문제
// heap을 사용하여 자료의 삽입/삭제를 빠르게 수행해야 합니다.
// 스코빌 지수가 K에 도달하지 못하는 경우 예외처리를 적절히 해 주어야 합니다.


import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int s: scoville) {
            pq.offer(s);
        }
        
        while (pq.peek() < K) {
            int s1 = pq.poll(); // 가장 맵지 않은 음식 삭제
            int s2 = pq.poll(); // 두 번째로 맵지 않은 음식 삭제
            int s = s1 + s2 * 2;
            pq.offer(s); //  섞은 음식 삽입
            
            answer++;
            
            if (pq.size() == 1 && pq.peek() < K) { // K에 도달하지 못하는 경우
                return -1;
            }
        }
        
        return answer;
    }
}
