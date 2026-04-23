import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for(int work : works){
            pq.add(work);
        }
        
        while(n -- > 0 && !pq.isEmpty()){
            int divT = pq.poll() - 1;
            if(divT == 0) continue;
            
            pq.add(divT);
        }
        
        long result = 0;
        while(!pq.isEmpty()){
            int num = pq.poll();
            result += (num*num);
        }
        
        return result;
        
    }
}