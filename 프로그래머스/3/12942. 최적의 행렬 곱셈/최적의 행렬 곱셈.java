import java.util.*;

class Solution {
    public int solution(int[][] matrix_sizes) {
        int answer = 0;
        
        int[][] dp = new int[201][201];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == j) dp[i][j] = 0;
            }
        }
        
        for (int i = 0; i < matrix_sizes.length; i++) {
            for (int j = 0; j < matrix_sizes.length - i; j++) {
                int a = j; 
                int b = j + i;
                
                for (int k = a; k < b; k++) {
                    dp[a][b] = Math.min(dp[a][b], dp[a][k] + dp[k + 1][b]
                                        + matrix_sizes[a][0] * matrix_sizes[k][1] * matrix_sizes[b][1]);
                }
            }
        }
        
        return dp[0][matrix_sizes.length - 1];
    }
}