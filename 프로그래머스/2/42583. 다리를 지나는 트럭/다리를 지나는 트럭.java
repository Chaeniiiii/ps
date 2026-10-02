import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i < bridge_length; i++){
            deque.add(0);
        }
        
        if(bridge_length == 1) return truck_weights.length + 1;
        if(truck_weights.length == 1) return bridge_length + 1;
        
        int t = 0;
        int w = 0;
        int idx = 0;
        
        while(idx < truck_weights.length){
            
            w -= deque.poll();
            t++;
            
            if(w + truck_weights[idx] <= weight){
                deque.add(truck_weights[idx]);
                w += truck_weights[idx++];
            }
            else deque.add(0);
            
        }
        
        return bridge_length + t;
    }
}