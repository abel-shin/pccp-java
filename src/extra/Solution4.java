// https://school.programmers.co.kr/learn/courses/30/lessons/42627

// 작업의 대기 시간을 최소화 하는 문제입니다.
// 동시에 기다리는 작업 중 더 빨리 끝나는 작업이 우선 끝나야 하므로,
// Heap을 이용하여 작업 시간이 더 짧은 작업부터 처리하면 됩니다.


import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] jobs) {
        int i = 0;
        int startTime = -1; // 작업이 시작된 시각
        int currentTime = 0; // 현재 시각
        int totalTime = 0;  // 총 대기 시간
        
        // 작업에 걸리는 시간 순으로 정렬하는 Min Heap
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1]; // 작업시간이 짧은 순으로
        });
        
        // 작업이 시작한 이래로 대기한 모든 작업 삽입
        while (i < jobs.length) {
            for (int[] j: jobs) {
                if (startTime < j[0] && j[0] <= currentTime) {
                    pq.offer(j);
                }
            }
            
            if (!pq.isEmpty()) { // 처리할 작업이 있으면 처리
                int[] j = pq.poll();
                int t = j[0]; 
                int jobTime = j[1];
                
                startTime = currentTime; // 작업 시작 시각 기록
                currentTime += jobTime; // 작업 처리 시간만큼 시간이 흐름
                totalTime += currentTime - t; // 전체 요청 종료까지 걸린 시간에 기록
                i++; // 작업 1개 처리
            } else {
                currentTime++; // 처리할 작업이 없으면 시간을 보낸다.
            }
        }
        
        return totalTime / jobs.length;
    }
}