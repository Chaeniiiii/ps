import java.util.*;

class Solution {
    
    private static String s;
    
    public int solution(String s) {
        
        this.s = s;
        int len = s.length(); 
        int result = len;
        
        for(int i = 1; i <= len/2; i++){
            result = Math.min(result,div(i));
        }
        
        return result;
        
    }
    
    private static int div(int cut){
        
        StringBuilder sb = new StringBuilder();
        StringBuilder total = new StringBuilder();
        
        Deque<String> deque = new ArrayDeque<>();
        int i = 0;
        
        for(; i < s.length();){
            sb = new StringBuilder();
            while(i < s.length() && sb.length() < cut){
                sb.append(s.charAt(i));
                i++;
            }
            
            String str = sb.toString();
            if(deque.isEmpty() || deque.peekLast().equals(str)){
                deque.add(str);
            }
            else{
                total.append(deque.size() < 2 ? deque.peekLast() : deque.size() + deque.peekLast());
                deque = new ArrayDeque<>();
                deque.add(str);
            }
            
        }
        
        if(sb.length() > 0){
            total.append(deque.size() < 2 ? deque.peekLast() : deque.size() + deque.peekLast());
        }
        
        return total.length();
        
    }
    
}