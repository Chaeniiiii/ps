import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        
        int[][] dp = new int[n+1][n+1];
        
        for(int[] result : results){
            int winner = result[0];
            int loser = result[1];
            
            dp[winner][loser] = 1;
            dp[loser][winner] = -1;
        }

        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=n; j++){
                for(int k = 1; k<=n; k++){
                    if(dp[i][k] == 1 && dp[k][j] == 1){
                        dp[i][j] = 1;
                        dp[j][i] = -1;
                    }
                    else if(dp[i][k] == -1 && dp[k][j] == -1){
                        dp[j][i] = 1;
                        dp[i][j] = -1;
                    }
                }
            }
        }
        
        int result = 0;
        for(int i = 1; i<=n; i++){
            int cnt = 0;
            for(int j = 1; j<=n; j++){
                if(dp[i][j] != 0){
                    cnt ++;
                }
            }
            if(cnt == n-1){
                result++;
            }
        }
        
        return result;
        
    }
}