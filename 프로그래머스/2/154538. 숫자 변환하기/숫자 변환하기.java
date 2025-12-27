import java.util.*;

class Solution {
    
    private static int result;
    
    public int solution(int x, int y, int n) {
        result = Integer.MAX_VALUE;
        dfs(x,y,n,0);
        
        return result == Integer.MAX_VALUE ? -1 : result;
    }
    
    private static void dfs(int x, int y, int n, int cnt){
        
        if(x > y) return;
        if(x == y){
            result = Math.min(result,cnt);
            return;
        }
        
        dfs(x*2,y,n,cnt+1);
        dfs(x*3,y,n,cnt+1);
        dfs(x+n,y,n,cnt+1);
        
    }
}