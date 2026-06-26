import java.util.*;

class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        
        if(grid[0][0] == 1) return 0;
        
        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int[n][m];
        dp[0][0] = 1;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0 && j == 0 || grid[i][j] == 1) continue;
                if(i - 1 < 0) dp[i][j] += dp[i][j-1];
                if(j - 1 < 0) dp[i][j] += dp[i-1][j];
                if(i - 1 >= 0 && j - 1 >= 0){
                    dp[i][j] += dp[i][j-1];
                    dp[i][j] += dp[i-1][j];
                }
            }
        }

        return dp[n-1][m-1];

    }
}