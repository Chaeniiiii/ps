import java.util.*;

class Solution {
    
    private static class Str {
        
        String str;
        int cnt;
        
        private Str(String str, int cnt){
            this.str = str;
            this.cnt = cnt;
        }
    }
    
    public int solution(String s) {
        
        if(s.length() == 1) return 1;
        
        Deque<Str> deque;
        int answer = Integer.MAX_VALUE;
        
        for(int i = 1; i<=s.length()/2; i++){   
            deque = new ArrayDeque<>();
            
            int lt = 0, rt = lt+i, len = 0, cnt = 1;
            
            while(lt < rt){
                
                String now;
                
                if(rt >= s.length()) now = s.substring(lt);
                else now = s.substring(lt,rt);
                
                if(deque.isEmpty() || !deque.peekLast().str.equals(now)){
                    deque.add(new Str(now,1));
                }
                else if(deque.peekLast().str.equals(now)){
                    Str prev = deque.peekLast();
                    prev.cnt ++;
                }
                
                if(rt > s.length()) break;
                
                lt+=i;
                rt+=i;
                
            }
            
            while(!deque.isEmpty()){
                Str target = deque.poll();
                len+=target.str.length();
                if(target.cnt > 1) len += String.valueOf(target.cnt).length();
            }
            
            answer = Math.min(answer,len);
            
            
        }
        
        return answer ;
        
    }
}