import java.util.*;

class Solution {
    
    private static int n,m;
    
    private static boolean[] visited;
    private static int[][] beginning;
    private static int[][] target;
    
    private static int result;
    
    public int solution(int[][] beginning, int[][] target) {

        n = beginning.length;
        m = beginning[0].length;
        this.beginning = beginning;
        this.target = target;
        
        visited = new boolean[n];
        
        result = Integer.MAX_VALUE;
        dfs(0,0);
        
        return result == Integer.MAX_VALUE ? - 1 : result;
        
    }
    
    private static void dfs(int dep, int cnt){
        
        if(dep > n || isCorrect(cnt)) return;
        
        for(int i = 0 ; i < n; i++){
            
            if(visited[i]) continue;
            
            visited[i] = true;
            int[] row = beginning[i].clone();
            for(int j = 0; j < m; j++){
                beginning[i][j] = (beginning[i][j] + 1) % 2;
            }
            dfs(dep+1,cnt+1);
            beginning[i] = row;
            visited[i] = false;
            
        }
        
    }
    
    private static boolean isCorrect(int cnt){
           
        for(int i = 0; i < m; i ++){
            int e = 0;
            for(int j = 0; j < n; j++){
                if(beginning[j][i] != target[j][i]) e++;
            }
            if(e == n) cnt++;
            else if(e != 0) return false;
        }
        
        result = Math.min(result,cnt);
        return true;
        
    }
    
}