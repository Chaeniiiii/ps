import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        
        int n = scoville.length;
        if(n == 1){
            if(scoville[0] < K) return -1;
            return 0;
        }

        int cnt = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < n ; i++){
            pq.add(scoville[i]);
        }
        
        while(pq.size() > 1 && pq.peek() < K){
            int num = pq.poll() + (pq.poll() * 2);
            pq.add(num);
            cnt++;
        }
        
        if(pq.peek() < K) return -1;
        return cnt;
        
    }
}