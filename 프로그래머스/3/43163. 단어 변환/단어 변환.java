import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        
        Deque<String> deque = new ArrayDeque<>();
        deque.add(begin);
        
        boolean [] visited = new boolean[words.length];
        
        int cnt = 0;
        while(!deque.isEmpty()){
            
            int size = deque.size();
            
            for(int i = 0; i<size; i++){
                String now = deque.poll();
                if(now.equals(target)) return cnt;
                
                for(int k = 0; k<words.length; k++){
                    if(visited[k]) continue;
                    if(getDifferentWord(now,words[k])) {
                        deque.add(words[k]);
                        visited[k] = true;
                    }
                }
                
            }
            
            cnt ++;
            
        }
        
        return 0;
        
    }
    
    private static boolean getDifferentWord(String a, String b){
        
        int cnt = 0;
        
        for(int i = 0; i<a.length(); i++){
            if(a.charAt(i) != b.charAt(i)) ++cnt;
            if(cnt > 1) return false;            
            
        }
        
        return true;
        
    }
    
}