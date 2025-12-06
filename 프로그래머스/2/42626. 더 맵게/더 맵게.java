import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(long s : scoville){
            pq.add(s);
        }
        
        if(pq.peek() >= K) return 0;
        
        int cnt = 0;
        while(pq.size() > 1){
            
            long now = pq.poll();
            if(now >= K) return cnt;
            long nxt = pq.poll();
            
            pq.add(now + nxt*2);
            cnt++;
            
        }
    
        if(pq.size() == 0) return -1;
        if(pq.size() == 1 && pq.peek() < K) return -1;
        return cnt;
        
    }
}