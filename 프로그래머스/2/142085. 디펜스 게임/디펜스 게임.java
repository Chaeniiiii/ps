import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        int cnt = 0;
        
        for(int i = 0; i < enemy.length; i++){
            
            n -= enemy[i];
            pq.add(enemy[i]);
            
            if(n < 0){
                if(k == 0) return i;
                if(k > 0 && !pq.isEmpty()){
                    k--;
                    n += pq.poll();
                }
            }
            
            cnt++;
            
        }
        
        return cnt;
        
    }
}