import java.util.*;

class Solution {
    
    public long solution(int n, int[] works) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        
        for(int work : works){
            pq.add(work);
        }
        
        while(n-- > 0 && !pq.isEmpty()){
            int now = pq.poll();
            if(now > 0) pq.add(now - 1);
            
        }
        
        long cnt = 0;
        while(!pq.isEmpty()){
            cnt += Math.pow(pq.poll(),2);
        }
        
        return cnt;
        
    }
    
}