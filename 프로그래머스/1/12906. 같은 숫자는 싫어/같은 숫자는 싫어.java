import java.util.*;

public class Solution {
    public int[] solution(int [] nums) {
        
        Deque<Integer> deque = new ArrayDeque<>();
        
        for(int num : nums){
            
            if(deque.isEmpty() || deque.peekLast() != num) {
                deque.add(num);
                continue;
            }
            
        }
        
        int [] result = new int[deque.size()];
        int idx = 0;
        while(!deque.isEmpty()){
            result[idx] = deque.poll();
            idx++;
        }
        
        return result;
        
    }
}