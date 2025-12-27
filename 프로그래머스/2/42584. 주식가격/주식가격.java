import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        
        int n = prices.length;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        pq.add(new int[]{prices[0],0});
        
        int[] result = new int[n];
        
        for(int i = 1; i < n; i++){
            int now = prices[i];
            while(!pq.isEmpty() && pq.peek()[0] > now){
                int[] prev = pq.poll();
                result[prev[1]] = i - prev[1];
            }
            pq.add(new int[]{now,i});
        }
        
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            result[now[1]] = n - 1 - now[1];
        }
        
        return result;
        
    }
}