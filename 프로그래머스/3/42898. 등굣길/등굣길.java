import java.util.*;

class Solution {
    
    private final int MOD = 1_000_000_007;
    
    public int solution(int m, int n, int[][] puddles) {
        
        int[][] dp = new int[m][n];
        boolean[][] pd = new boolean[m][n];
        
        for(int [] puddle : puddles){
            pd[puddle[0]-1][puddle[1]-1] = true;
        }
        
        dp[0][0] = 1;
        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n; j++){
                if(i+1 < m && !pd[i+1][j]) dp[i+1][j] += dp[i][j] % MOD;
                if(j+1 < n && !pd[i][j+1]) dp[i][j+1] += dp[i][j] % MOD;
            }
        }
        
        return dp[m-1][n-1] % MOD;
        
    }
}