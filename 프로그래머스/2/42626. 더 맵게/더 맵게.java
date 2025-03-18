import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int num : scoville) pq.add(num);
        
        int cnt = 0;
        while(pq.size() > 1){
    
            int num = pq.peek();
            
            if(num < K){
                num = pq.poll() + pq.poll()*2;
                pq.add(num);
                cnt ++;
            }
            else{
                break;
            }
        }
        
        return pq.peek() >= K ? cnt : -1;
        
    }
}