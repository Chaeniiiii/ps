import java.util.*;

class Solution {
    
    public int solution(int m, int n, int[][] puddles) {
        
        final int MOD = 1_000_000_007;
        
        boolean[][] puddle = new boolean[m+1][n+1];
        int[][] dp = new int[m+1][n+1];
        dp[1][1] = 1;
        
        for(int [] p : puddles){
            puddle[p[0]][p[1]] = true;
        }
        
        for(int i = 1; i <= m ; i++){
            for(int j = 1 ; j <= n; j++){
                if(puddle[i][j]) continue;
                if(i > 1) dp[i][j] = (dp[i][j] + dp[i-1][j]) % MOD;
                if(j > 1) dp[i][j] = (dp[i][j] + dp[i][j-1]) % MOD;
            }
        }
        
        return dp[m][n];
    }
}