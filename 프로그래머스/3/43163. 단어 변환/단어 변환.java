import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        
        Deque<String> deque = new ArrayDeque<>();
        deque.add(begin);
        
        boolean[] visited = new boolean[words.length];
        int cnt = 0;
        
        while(!deque.isEmpty()){
            
            for(int k = 0; k < deque.size(); k++){
                
                String now = deque.poll();
                
                if(now.equals(target)){
                    return cnt;
                }
            
                for(int i = 0; i < words.length; i++){
                    if(visited[i]) continue;
                    if(check(words[i], now)){
                        deque.add(words[i]);
                        visited[i] = true;
                    }
                }
                
            }
            
            cnt++;
            
        }
        
        return 0;
        
    }
    
    private static boolean check(String target, String origin){
        
        int cnt = 0;
        
        for(int i = 0; i < origin.length(); i++){
            
            if(target.charAt(i) != origin.charAt(i)){
                cnt++;
            }         
            
            if(cnt > 1) return false;
            
        }
        
        return cnt == 0 ? false : true;
        
    }
}