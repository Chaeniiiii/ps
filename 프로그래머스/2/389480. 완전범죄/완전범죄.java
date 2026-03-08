import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {

        if(info.length == 1){
            return info[0][1] < m ? 0 : info[0][0];
        } 
        
        int[][] dp = new int[info.length][m];
        
        for(int i = 0; i < info.length; i++){
            Arrays.fill(dp[i],120);
        }
        dp[0][0] = info[0][0];
        if(info[0][1] < m) dp[0][info[0][1]] = 0; //노이해 
        
        for(int i = 1; i < info.length; i++){
            for(int j = 0; j < m; j++){
                dp[i][j] = Math.min(dp[i][j],dp[i-1][j]+ info[i][0]);
                
                if(j + info[i][1] < m){
                    dp[i][j+info[i][1]] = Math.min(dp[i][j+info[i][1]],dp[i-1][j]);
                }
                
            }
        }
        
        int result = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++){
            result = Math.min(result,dp[info.length-1][i]);
        }
        
       return result < n ? result : -1; 
        
    }
}