import java.util.*;

class Solution {
    
    private static final int MAX = 120;
        
    public int solution(int[][] info, int n, int m) {
        
        int len = info.length;
        int[][] dp = new int[len][m];
        
        for(int i = 0; i < len; i++){
            Arrays.fill(dp[i],MAX);
        }
        
        dp[0][0] = info[0][0];
        if(info[0][1] < m){
            dp[0][info[0][1]] = 0;
        }
        
        for(int i = 1; i < len; i++){
            for(int j = 0; j < m; j++){
                dp[i][j] = Math.min(dp[i][j],dp[i-1][j]+info[i][0]);
                
                if(j + info[i][1] < m){
                    dp[i][j+info[i][1]] = Math.min(dp[i][j+info[i][1]],dp[i-1][j]);
                }
            }
        }
        
        int result = MAX;
        for(int i = 0; i < m; i++){
            result = Math.min(result,dp[len-1][i]);
        }
        
        return result >= n ? -1 : result;
        
    }
    
    
}