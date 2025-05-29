import java.util.*;

class Solution {
    boolean solution(String s) {
        
        Deque<Character> deque = new ArrayDeque<>();
        
        for(char c : s.toCharArray()){
            if(c == '(') deque.add(c);
            else{
                if(deque.isEmpty()) return false;
                deque.pollLast();
            }
        }
        
        return deque.isEmpty() ? true : false;
        
    }
}