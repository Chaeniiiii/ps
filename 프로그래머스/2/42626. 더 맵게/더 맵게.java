import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int scv : scoville) pq.add(scv);
        
        int score = 0;
        int cnt = 0;
        
        while(!pq.isEmpty()){
            
            if(pq.peek() >= K) return cnt;
            
            for(int i = 0; i<2; i++){
                if(pq.isEmpty()) return score >= K ? cnt : -1;
                if(i == 1) {
                    score +=(pq.poll()*2);
                    pq.add(score);
                    cnt ++;
                    score = 0;
                }
                else score+=pq.poll();
            }
            
        }
        
        return pq.peek() < K ? -1 : cnt;
        
    }
}