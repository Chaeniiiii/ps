import java.util.*;

class Solution {
    
    private int result;
    private boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        
        result = Integer.MAX_VALUE;
        visited = new boolean[words.length];
        
        dfs(0, begin, target, words);
        return result == Integer.MAX_VALUE ? 0 : result;
        
    }
    
    private void dfs(int cnt, String begin, String target, String[] words){
        
        if(begin.equals(target)){
            result = Math.min(result,cnt);
            return;
        }
        
        for(int i = 0; i < words.length; i++){
            if(visited[i]) continue;
            if(isPossible(begin,words[i])){
                visited[i] = true;
                dfs(cnt+1, words[i], target,words); 
                visited[i] = false;
            }
        }
        
    }
    
    private boolean isPossible(String begin, String target){
        
        int cnt = 0;
        for(int i = 0; i < begin.length(); i++){
            if(begin.charAt(i) != target.charAt(i)) cnt++;
            if(cnt > 1) return false;
        }
        
        return true;
        
    }
}