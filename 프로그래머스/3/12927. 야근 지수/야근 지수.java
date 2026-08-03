import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        for(int i = 0; i < works.length; i++){
            pq.add(works[i]);
        }
        
        for(int i = 0; i < n; i++){
            if(pq.isEmpty()) break;
            int task = pq.poll();
            if(task <= 1) continue;
            pq.add(task - 1);
        }
        
        long result = 0;
        while(!pq.isEmpty()){
            int div = pq.poll();
            result += div * div;
        }
        
        return result;
        
    }
}