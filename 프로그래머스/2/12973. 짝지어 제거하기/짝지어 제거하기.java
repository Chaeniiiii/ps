import java.util.*;

class Solution{
    public int solution(String s){
        
        Deque<Character> deque = new ArrayDeque<>();
        for(char c : s.toCharArray()){
            if(!deque.isEmpty() && deque.peekLast() == c){
                deque.pollLast();  
                continue;
            }
            deque.add(c);
        }
        
        return deque.size() == 0 ? 1 : 0;
        
    }
}