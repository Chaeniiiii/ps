import java.util.*;

class Solution {
    public int solution(int[][] matrix_sizes) {
        
        int n = matrix_sizes.length;
        
        int[][] dp = new int[n][n];
        for(int i = 0 ; i < n; i ++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
            dp[i][i] = 0;
        }
        
        for(int i = 1; i < n; i++){
            for(int st = 0; st + i < n; st++){
                
                int en = i + st;
                
                for(int k = st; k < en; k++){
                    dp[st][en] = Math.min(dp[st][en], dp[st][k] + dp[k+1][en] + (matrix_sizes[st][0] * matrix_sizes[k][1] * matrix_sizes[en][1]));
                }
                
            }
        }
        
        return dp[0][matrix_sizes.length - 1];
        
        
    }
}