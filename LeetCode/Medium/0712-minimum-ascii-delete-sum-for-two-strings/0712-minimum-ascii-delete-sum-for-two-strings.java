import java.util.*;

class Solution {
    public int minimumDeleteSum(String s1, String s2) {
    
        int n = s1.length();
        int m = s2.length();

        char[] sc1 = s1.toCharArray();
        char[] sc2 = s2.toCharArray();

        int[][] dp = new int[n+1][m+1];

        for(int i = 1; i <= n; i++){
            dp[i][0] = dp[i-1][0]+(int)sc1[i-1];
        }
        for(int i = 1; i <= m; i++){
            dp[0][i] = dp[0][i-1]+(int)sc2[i-1];
        }


        for(int i = 1 ; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(sc1[i-1] == sc2[j-1]){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.min(dp[i-1][j] + (int)sc1[i-1], dp[i][j-1] + (int)sc2[j-1]);
                }
            }
            System.out.println(Arrays.toString(dp[i]));
        }

        return dp[n][m];


    }
}