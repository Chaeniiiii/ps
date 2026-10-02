import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        
        Deque<int[]> deque = new ArrayDeque<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        
        for(int i = 0; i < priorities.length; i++){
            deque.add(new int[]{i,priorities[i]});
            pq.add(priorities[i]);
        }
        
        int max = pq.poll();
        int cnt = 1;
        
        while(!deque.isEmpty()){
            
            int[] now = deque.poll();
            if(now[1] == max){
                if(now[0] == location) return cnt;
                cnt ++ ;
                max = pq.poll();
            }
            else{
                deque.add(now);
            }
            
        }
        
        return priorities.length - 1;
        
    }
}