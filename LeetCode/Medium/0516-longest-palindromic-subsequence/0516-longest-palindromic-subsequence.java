import java.util.*;

class Solution {
    public int longestPalindromeSubseq(String s) {

        int len = s.length();
        int[][] dp = new int[len][len];   
        for(int i = 0; i < len; i++){
            dp[i][i] = 1;
        }
        
        int result = 1;    

        for(int i = len - 1; i >= 0; i--){
            for(int j = i + 1; j < len; j++){
                if(i == j) dp[i][j] = 1;
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = 2 + dp[i+1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                }
                result = Math.max(result,dp[i][j]);
            }
        }

        return result;

    }
}