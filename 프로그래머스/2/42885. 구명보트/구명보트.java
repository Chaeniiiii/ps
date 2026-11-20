import java.util.*;

class Solution {
    public int solution(int[] people, int k) {
        
        Arrays.sort(people);
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i < people.length; i++){
            deque.add(people[i]);
        }
        
        int w = 0, result = 0;
        while(!deque.isEmpty()){
            w += deque.pollLast();
            if(!deque.isEmpty() && deque.peek() + w <= k) deque.poll();
            
            w = 0;    
            result++;
        }
        
        return result;
        
        
    }
}