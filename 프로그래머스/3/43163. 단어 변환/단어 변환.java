import java.util.*;

class Solution {
    
    private String[] words;
    private boolean[] visited;
    
    private int result;
    
    public int solution(String begin, String target, String[] words) {

        visited = new boolean[words.length];
        result = Integer.MAX_VALUE;
        this.words = words;
        
        dfs(0, begin,target);
        
        return result == Integer.MAX_VALUE ? 0 : result;
        
    }
    
    private void dfs(int dep, String begin, String target){
        
        if(begin.equals(target)){
            result = Math.min(result,dep);
            return;
        }
        
        for(int i = 0; i < words.length; i++){
            if(visited[i]) continue;
            
            visited[i] = true;
            if(isPossible(begin, words[i])) dfs(dep+1,words[i],target);
            visited[i] = false;
        }
        
    }
    
    private boolean isPossible(String a, String b){
        
        int cnt = 0;
        for(int i = 0; i < a.length(); i++){
            if(cnt > 1) return false;
            if(a.charAt(i) != b.charAt(i)) cnt++;
        }
        
        return cnt < 2 ? true : false;
        
    }
    
}