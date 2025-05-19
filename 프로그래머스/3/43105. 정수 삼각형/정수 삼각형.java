import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        
        int row = triangle.length;
        int col = triangle[row-1].length;
        
        int [][] dp = new int[row][col];
        dp[0][0] = triangle[0][0];
        
        for(int i = 1; i<row; i++){
            for(int j = 0; j<col; j++){
                if(j-1 >= 0 && j-1 < triangle[i-1].length) dp[i][j] = Math.max(triangle[i][j]+dp[i-1][j-1],dp[i][j]);
                if(j < triangle[i-1].length) dp[i][j] = Math.max(triangle[i][j]+dp[i-1][j],dp[i][j]);
            }
        }
        
        int result = 0;
        for(int i = 0; i<col; i++){
            result = Math.max(result,dp[col-1][i]);
        }
        
        return result;
        
        
    }
}