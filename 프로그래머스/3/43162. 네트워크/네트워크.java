import java.util.*;

class Solution {
    
    private int n;
    
    private int[][] computers;
    private boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        
        this.n = n;
        this.computers = computers;
        
        visited = new boolean[n];
        
        int cnt = 0;
        for(int i = 0; i < n; i++){
            if(visited[i]) continue;
            dfs(i);
            cnt++;
        }
        
        return cnt;
        
    }
    
    private void dfs(int node){
        
        if(visited[node]) return;
        visited[node] = true;
        
        for(int i = 0; i < n; i++){
            if(computers[node][i] == 1) dfs(i);
        }
        
    }
}