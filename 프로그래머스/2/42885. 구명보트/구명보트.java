import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        
        Arrays.sort(people);
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = people.length - 1; i >= 0; i--){
            deque.add(people[i]);
        }
        
        int cnt;
        int result = 0;
        while(!deque.isEmpty()){
            
            cnt = 0;
            cnt += deque.poll();

            if(!deque.isEmpty() && deque.peekLast() + cnt <= limit){
                cnt += deque.pollLast();
            }
            
            result++;
            
        }
        
        return result;
        
         
    }
}