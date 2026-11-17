import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(0);
        
        int[] result = new int[numbers.length];
        for(int i = 1; i < numbers.length; i++){
            
            while(!deque.isEmpty() && numbers[deque.peekLast()] < numbers[i]){
                result[deque.pollLast()] = numbers[i];
            }
            
            deque.add(i);
        }
        
        while(!deque.isEmpty()){
            result[deque.poll()] = -1;
        }
        
        return result;
        
    }
}