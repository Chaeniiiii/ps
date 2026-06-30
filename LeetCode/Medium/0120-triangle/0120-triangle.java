import java.util.*;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        int n = triangle.size();
        int m = triangle.get(n - 1).size();

        int[][] tri = new int[n][m];
        int[][] dp = new int[n][m];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i],10000);
            for(int j = 0; j < triangle.get(i).size(); j++){
                tri[i][j] = triangle.get(i).get(j);
            }
        }
        dp[0][0] = tri[0][0];

        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < triangle.get(i).size(); j++){
                dp[i+1][j] = Math.min(dp[i+1][j],dp[i][j] + tri[i+1][j]);
                dp[i+1][j + 1] = Math.min(dp[i+1][j+1],dp[i][j] + tri[i+1][j+1]);
            }
        }

        int result = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++){
            result = Math.min(result,dp[n-1][i]);
        }
        
        return result;

    }
}