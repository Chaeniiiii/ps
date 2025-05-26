import java.util.*;

class Solution {
    public int solution(String s) {
        
        int cnt = 0;
        for(int i = 0; i<s.length(); i++){
            
            String newStr = s.substring(i) + s.substring(0,i);
            
            Deque<Character> deque = new ArrayDeque<>();
            boolean check = false;
            
            for(char c : newStr.toCharArray()){
                
                if(c == '(' || c == '{' || c == '[') deque.add(c);
                else {
                    if(deque.isEmpty()){
                        check = true;
                        break;
                    }
                    char open = deque.pollLast();
                    
                    if(open == '(' && c == ')') continue;
                    else if(open == '{' && c == '}') continue;
                    else if(open == '[' && c == ']') continue;
                    else {
                        check = true;
                        break;
                    }
                }
            }
            
            if(!check && deque.isEmpty()) cnt ++;
            
        }
        
        return cnt;
        
    }
}