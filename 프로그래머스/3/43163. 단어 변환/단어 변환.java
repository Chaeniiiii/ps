import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        
        Deque<String> deque = new ArrayDeque<>();
        deque.add(begin);
        
        boolean[] visited = new boolean[words.length];
        
        int cnt = 0;
        while(!deque.isEmpty()){
            
            int size = deque.size();
            
            for(int i = 0; i<size; i++){
                
                String now = deque.poll();
                if(now.equals(target)){
                    return cnt;
                }
                
                for(int t = 0; t<words.length; t++){
                    if(visited[t]){
                        continue;
                    }
                    if(checkStr(now,words[t])){
                        deque.add(words[t]);
                        visited[t] = true;
                    }
                }
            }
            
            cnt ++;
            
        }
        
        return 0;
        
    }
    
    private static boolean checkStr(String now, String nxt){
        
        if(now.length() != nxt.length()){
            return false;
        }
        
        int cnt = 0;
        for(int i = 0; i<now.length(); i++){
        
            if(now.charAt(i) != nxt.charAt(i)){
                cnt ++;
            }
            
            if(cnt >= 2){
                return false;
            }
            
        }
        
        return true;
        
    }
}