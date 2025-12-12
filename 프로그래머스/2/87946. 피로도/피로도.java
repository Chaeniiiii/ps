import java.util.*;

class Solution {
    
    private static int n,result;
    
    private static int[][] dungeons;
    private static boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        
        n = dungeons.length;
        result = 0;
        
        this.dungeons = dungeons;
        visited = new boolean[n];
        
        dfs(-1,0,k);
        return result;
        
    }
    
    private static void dfs(int st, int dep, int k){
        
        result = Math.max(result,dep);
        
        for(int i = 0; i < n; i++){
        
            if(visited[i] || dungeons[i][0] > k) continue;
            visited[i] = true;
            dfs(i,dep+1,k-dungeons[i][1]);
            visited[i] = false;
            
        }
        
    }
    
}
