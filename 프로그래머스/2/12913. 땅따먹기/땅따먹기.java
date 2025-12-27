import java.util.*;

class Solution {
    int solution(int[][] land) {
        
        int n = land.length;
        
        int[][] dp = new int[n][4];
        dp[0] = land[0].clone();
        
        for(int i = 1; i < n; i++){
            dp[i][0] += land[i][0] + Math.max(dp[i-1][1],Math.max(dp[i-1][2],dp[i-1][3]));
            dp[i][1] += land[i][1] + Math.max(dp[i-1][0],Math.max(dp[i-1][2],dp[i-1][3]));
            dp[i][2] += land[i][2] + Math.max(dp[i-1][0],Math.max(dp[i-1][1],dp[i-1][3]));
            dp[i][3] += land[i][3] + Math.max(dp[i-1][0],Math.max(dp[i-1][2],dp[i-1][1]));
        }
        
        int max = 0;
        for(int i = 0; i < 4; i++){
            max = Math.max(max,dp[n-1][i]);
        }
        
        return max;
        
    }
}