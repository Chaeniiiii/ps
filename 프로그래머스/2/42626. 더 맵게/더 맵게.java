import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < scoville.length; i++){
            pq.add(scoville[i]);
        }
        
        int cnt = 0;
        while(pq.size() >= 2 && pq.peek() < K){
            int a = pq.poll();
            int b = pq.poll();
            
            pq.add(a + b * 2);
            cnt++;
        }
        
        if(pq.peek() < K) return -1;
        return cnt;
        
    }
}