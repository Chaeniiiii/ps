import java.util.*;

class Solution {
    public int solution(String s) {
        
        StringBuilder sb;
        Deque<String> deque;
        
        int len = s.length();
        int answer = len;
        
        for(int i = 1; i<=len/2; i++){
            sb = new StringBuilder();
            deque = new ArrayDeque<>();
            
            for(int j = 0; j<len; j+=i){
                int end = j + i;
                if(end >= len) deque.add(s.substring(j));
                else deque.add(s.substring(j,end));
            }
            
            while(!deque.isEmpty()){
                String now = deque.poll();
                int cnt = 1;
                while(!deque.isEmpty() && deque.peek().equals(now)){
                    deque.poll();
                    cnt ++;
                }
                if(cnt > 1) sb.append(cnt).append(now);
                else sb.append(now);
            }
            
            answer = Math.min(answer,sb.toString().length());
            
        }
        
        return answer;
        
        
    }
}