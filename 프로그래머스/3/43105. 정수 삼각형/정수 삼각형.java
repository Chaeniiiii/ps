import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        
        int r = triangle.length;
        int[][] dp = new int[r][r];
        dp[0][0] = triangle[0][0];
        
        for(int i = 0; i < r - 1; i++){
            for(int j = 0; j < triangle[i].length; j++){
                dp[i+1][j] = Math.max(dp[i+1][j],dp[i][j] + triangle[i+1][j]);
                dp[i+1][j+1] = Math.max(dp[i+1][j+1],dp[i][j] + triangle[i+1][j+1]);
            }
        }
        
        int result = 0;
        for(int i = 0; i < triangle[r-1].length; i++){
            result = Math.max(result,dp[r-1][i]);
        }
        
        return result;
        
        
    }
}