import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        
        Deque<String> deque = new ArrayDeque<>();
        deque.add(begin);
        
        Set<String> set = new HashSet<>();
        
        int cnt = 0;
        while(!deque.isEmpty()){
            
            int size = deque.size();
            
            for(int i = 0; i<size; i++){
                
                String now = deque.poll();
                if(now.equals(target)) return cnt;
                
                for(String next : words){
                    if(set.contains(next) || !isPossible(now,next)) continue;
                    set.add(next);
                    deque.add(next);
                }
                
            }
            
            cnt ++;
            
        }
        
        return 0;
        
    }
    
    private static boolean isPossible(String origin, String other){
            
        if(origin.length() != other.length()) return false;

        int cnt = 0;
        for(int i = 0; i<origin.length(); i++){
            if(origin.charAt(i) == other.charAt(i)) continue;
            cnt ++;
            if(cnt >= 2) return false;
        }

        return true;


    }
    
}