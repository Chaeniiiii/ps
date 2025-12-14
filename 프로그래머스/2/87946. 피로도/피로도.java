import java.util.*;

class Solution {
    
    private static int n;
    private static int[][] d;
    private static boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
            
        d = dungeons;
        n = d.length;
        
        visited = new boolean[n];
        
        return dfs(k,0);
        
    }
    
    private static int dfs(int k, int dep){
        
        int cnt = 0;
        
        for(int i = 0; i < d.length; i++){
            
            if(d[i][0] > k || visited[i]) continue;
            visited[i] = true;
            cnt = Math.max(cnt,dfs(k-d[i][1],dep+1));
            visited[i] = false;
            
        }
        
        return Math.max(cnt,dep);
        
    }
}