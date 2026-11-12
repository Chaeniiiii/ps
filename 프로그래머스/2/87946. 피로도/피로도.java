import java.util.*;

class Solution {
    
    private int result;
    private int[][] dungeons;
    private boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        
        result = 0;
        this.dungeons = dungeons;
        visited = new boolean[dungeons.length];
        
        dfs(k, 0, 0);
        return result;
        
    }
    
    private void dfs(int k, int dep, int cnt){
        
        if(dep == dungeons.length){
            result = Math.max(cnt,result);
            return;
        }
        
        for(int i = 0; i < dungeons.length; i++){
            if(visited[i]) continue;
            visited[i] = true;
            if(dungeons[i][0] > k) dfs(k, dep+1, cnt);
            else dfs(k - dungeons[i][1], dep+1, cnt + 1);
            visited[i] = false;
        }
        
    }
    
}