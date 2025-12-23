import java.util.*;

class Solution {
    public int solution(int[] scoville, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int s : scoville){
            pq.add(s);
        }
        
        int cnt = 0;
        while(pq.size() >= 2){
            
            int cur = pq.poll();
            int nxt = pq.poll();
            
            if(cur >= k) return cnt;
            if(nxt >= k) return cnt+1;
            
            pq.add(cur + nxt * 2);
            
            cnt++;
            
        }
        
        return pq.peek() >= k ? cnt : -1;
        
    }
}