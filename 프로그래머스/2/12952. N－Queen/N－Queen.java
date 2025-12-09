import java.util.*;

class Solution {
    
    private static int n,result;
    private static boolean[][] visited;
    private static boolean[] col;
    
    
    public int solution(int n) {

        this.n = n;
        result = 0;
        
        visited = new boolean[n][n];
        col = new boolean[n];
        dfs(-1,-1);
        
        return result;
        
    }
    
    private static void dfs(int x, int y){
        
        if(x == n - 1){
            result++;
            return;
        }
        
        for(int nxt = 0; nxt < n; nxt++){
            
            //대각선 왼쪽 위
            if(!LT(x+1,nxt)) continue;
            //대각선 오른쪽 위 
            if(!RT(x+1,nxt)) continue;
            //열
            if(col[nxt]) continue;
            
            col[nxt] = true;
            visited[x+1][nxt] = true;
            dfs(x+1,nxt);
            visited[x+1][nxt] = false;
            col[nxt] = false;
        }
    }
    
    private static boolean LT(int x, int y){
        
        while(x >= 0 && y >= 0){
            if(visited[x][y]) return false;
            x--;
            y--;
        }
        return true;
    }
    
    private static boolean RT(int x, int y){
        while(x >= 0 && y < n){
            if(visited[x][y]) return false;
            x--;
            y++;
        }
        return true;
    }
}