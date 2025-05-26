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
                    if(deque.isEmpty() || !match(deque.pollLast(),c)){
                        check = true;
                        break;
                    }
                }
            }
            
            if(!check && deque.isEmpty()) cnt ++;
            
        }
        
        return cnt;
        
    }
    
    private static boolean match(char a, char b){
        
        if(a == '(' && b == ')' || a == '{' && b == '}' || a == '[' && b == ']') return true;
        return false; 
    }
    
}