import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        
        int[] result = new int[prices.length];
        Deque<Integer> deque = new ArrayDeque<>();
        
        for(int i = 0; i < prices.length; i++){
            
            int now = prices[i];
            while(!deque.isEmpty() && prices[deque.peekLast()] > now){
                int idx = deque.pollLast();
                result[idx] = i - idx;
            }
            deque.add(i);
        }
        
        while(!deque.isEmpty()){
            int idx = deque.poll();
            result[idx] = prices.length - idx - 1;
        }
        
        return result;
        
    }
}