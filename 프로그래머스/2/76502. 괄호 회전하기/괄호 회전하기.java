import java.util.*;

class Solution {
    public int solution(String s) {
        
        int n = s.length();
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            sb.append(s.charAt(i));
        }
        
        int lt = 0, cnt = 0;
        while(lt < n){
            
            if(isPossible(sb.toString())) cnt++;
            
            sb.append(s.charAt(lt));
            sb.deleteCharAt(0);
            
            lt++;
            
            
        }
        
        return cnt;
        
    }
    
    private static boolean isPossible(String str){
        
        Deque<Character> deque = new ArrayDeque<>();
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(c == '{' || c == '[' || c == '('){
                deque.add(c);
                continue;
            }
            if(deque.isEmpty()) return false;
            char prev = deque.peekLast();
            if(c == ']' && prev != '[') return false;
            if(c == '}' && prev != '{') return false;
            if(c == ')' && prev != '(') return false;
            deque.pollLast();
        }
        
        return deque.size() == 0 ? true : false;
        
    }
}