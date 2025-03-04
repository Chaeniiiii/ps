import java.util.*;

class Solution
{
    public int solution(String s){
        
        Deque<Character> deque = new ArrayDeque<>();
        
        for(char c : s.toCharArray()){
    
            if(deque.isEmpty()) deque.add(c);
            else {
                if(deque.peekLast() == c) deque.pollLast();
                else deque.add(c);
            }
            
        }
        
        return deque.isEmpty() ? 1 : 0;
        
    }
}