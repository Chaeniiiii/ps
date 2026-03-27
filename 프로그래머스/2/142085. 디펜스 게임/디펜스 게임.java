import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        
        int i = 0;
        for(; i < enemy.length; i++){
            
            int enm = enemy[i];
            n -=enm;
            pq.add(enm);
            
            if(k > 0 && n < 0 && !pq.isEmpty()){
                k--;
                n += pq.poll();
            }
            
            if(n < 0) break;
            
        } 
        
        return i;
        
    }
}