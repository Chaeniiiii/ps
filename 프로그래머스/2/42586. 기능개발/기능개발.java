import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        Deque<Integer> deque = new ArrayDeque<>();
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int i = 0; i<progresses.length; i++){
            
            int day = (100-progresses[i])/speeds[i];
            int divide = (100-progresses[i])%speeds[i];
            
            if(divide != 0) deque.add(day+1);
            else deque.add(day);
            
        }
        
        while(!deque.isEmpty()){
            
            int now = deque.poll();
            int cnt = 1;
            
            while(!deque.isEmpty() && now >= deque.peek()){
                deque.poll();
                cnt++;
            }
            
            arr.add(cnt);
            
        }
        
        int [] result = new int[arr.size()];
        for(int i = 0; i<result.length; i++) result[i] = arr.get(i);
        
        return result;
        
    }
}