import java.util.*;

class Solution {
    
    private static boolean[][] visited;
    private static boolean[] col;
    
    public int solution(int n) {
        
        col = new boolean[n];
        visited = new boolean[n][n];
        
        return dfs(n,0);
        
    }
    
    private static int dfs(int n , int dep){
        
        int cnt = 0;
        
        if(dep == n){
            return 1;
        }
        
        for(int i = 0; i < n; i++){
            
            if(col[i] || visited[dep][i] || !mvl(dep,i,n) || !mvr(dep,i,n)) continue;
            col[i] = true;
            visited[dep][i] = true;
            cnt += dfs(n,dep+1);
            col[i] = false;
            visited[dep][i] = false;
            
        }
        
        return cnt;
        
    }
    
    private static boolean mvl(int x, int y, int n){
        
        for(int i = x; i > 0; i--){
            int mx = i - 1;
            y -= 1;
            
            if(mx < 0 || y < 0) break;
            if(visited[mx][y]) return false;
        }
        
        return true;
        
    }
    
    private static boolean mvr(int x, int y, int n){
        
        for(int i = x; i > 0; i--){
            int mx = i - 1;
            y += 1;
            
            if(mx < 0 || y >= n) break;
            if(visited[mx][y]) return false;
        }
        
        return true;
        
    }
    
}