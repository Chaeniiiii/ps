import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        
        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];
        
        for(int i = 0; i < triangle.length - 1; i++){
            for(int j = 0; j < triangle[i].length; j++){
                
                dp[i+1][j] = Math.max(dp[i+1][j], triangle[i+1][j] + dp[i][j]);
                dp[i+1][j+1] = Math.max(dp[i+1][j+1], triangle[i+1][j+1] + dp[i][j]);
                                
            }
        }
        
        int cnt = 0;
        for(int i = 0; i < dp[triangle.length-1].length; i++){
            cnt = Math.max(cnt,dp[triangle.length-1][i]);
        }
        
        return cnt;
        
    }
}