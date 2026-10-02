import java.util.*;

class Solution {
    boolean solution(String s) {
        
        Deque<Character> deque = new ArrayDeque<>();
        for(char c : s.toCharArray()){
            if(c == ')'){
                if(deque.isEmpty()) return false;
                deque.pollLast();
            }
            else{
                deque.add(c);
            }
        }
        
        return deque.size() == 0 ? true : false;
        
    }
}