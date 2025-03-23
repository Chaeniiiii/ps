import java.util.*;

class Solution {
    
    private static boolean [] visited;
    private static int total;
    
    public int solution(int k, int[][] dungeons) {
    
        total = 0;
        visited = new boolean[dungeons.length];
        dfs(0,k,dungeons);
        
        return total;
        
    }
    
    private static void dfs(int dep, int k, int [][] dungeons){
        
        if(dep > dungeons.length) return;
        
        for(int i = 0; i<dungeons.length; i++){
            
            if(!visited[i] && dungeons[i][0] <= k){
                
                visited[i] = true;
                dfs(dep+1,k-dungeons[i][1],dungeons);
                visited[i] = false;
                
            }
            
        }
        
        total = Math.max(dep,total);
        
    }
}