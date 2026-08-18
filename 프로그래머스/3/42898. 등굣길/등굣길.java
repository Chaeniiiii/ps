import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        
        final int MOD = 1_000_000_007;
        int[][] map = new int[m][n];
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        
        for(int i = 0; i < puddles.length; i++){
            int[] pos = puddles[i];
            map[pos[0]-1][pos[1]-1] = 1;
        }
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i - 1 >= 0 && map[i-1][j] == 0) dp[i][j] += dp[i-1][j] % MOD ;
                if(j - 1 >= 0 && map[i][j-1] == 0) dp[i][j] += dp[i][j-1] % MOD ;
            }
        }
        
        return dp[m-1][n-1] % MOD;
        
    }
}