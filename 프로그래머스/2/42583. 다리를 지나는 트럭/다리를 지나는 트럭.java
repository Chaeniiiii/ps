import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        Deque<Integer> deque = new ArrayDeque<>();

        int w = 0, t = 0;
        
        for(int i = 0; i < truck_weights.length; i++){
            
            int now = truck_weights[i];
            
            while(true){
                
                if(deque.isEmpty()){
                    deque.add(now);
                    w+=now;
                    t++;
                    break;
                }
                else if(deque.size() == bridge_length){
                    w -= deque.poll();
                }
                else{
                    if(w + now <= weight){
                        deque.add(now);
                        w+=now;
                        t++;
                        break;
                    }
                    else{
                        deque.add(0);
                        t++;
                    }
                }
            }
        }
        
        return t + bridge_length;
        
    }
}