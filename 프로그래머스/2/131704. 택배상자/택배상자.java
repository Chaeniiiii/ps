import java.util.*;

class Solution {
    public int solution(int[] order) {
        
        int idx = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        
        for(int i = 1; i <= order.length; i++){
            deque.addFirst(i);
            while(!deque.isEmpty() && deque.peek() == order[idx]){
                idx++;
                deque.poll();
            }
        }
        
        return idx;
        
    }
}