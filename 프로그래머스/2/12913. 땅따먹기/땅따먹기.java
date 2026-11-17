import java.util.*;

class Solution {
    int solution(int[][] land) {
        
        int n = land.length;
        int m = land[0].length;
        
        int[][] dp = new int[n][m];
        dp[0] = land[0].clone();
        
        for(int i = 1; i < n; i++){
            for(int j = 0; j < m; j++){
                for(int k = 0; k < m; k++){
                    if(j == k) continue;
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][k] + land[i][j]);
                }
            }
        }
        
        int result = 0;
        for(int i = 0; i < m; i++){
            result = Math.max(result,dp[n-1][i]);
        }
        
        return result;
        
    }
}