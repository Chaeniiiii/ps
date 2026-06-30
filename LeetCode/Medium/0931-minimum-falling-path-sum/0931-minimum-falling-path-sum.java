class Solution {
    public int minFallingPathSum(int[][] matrix) {

        int n = matrix.length;
        int[][] dp = new int[n][n];

        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i],100*n+1);
        }
        dp[0] = matrix[0].clone();

        for(int i = 1; i < n; i++){
            for(int j = 0; j < n; j++){
                if(j == 0){
                    dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j+1]) + matrix[i][j];
                }
                else if(j == n - 1){
                    dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j-1]) + matrix[i][j];
                }
                else{
                    dp[i][j] = Math.min(Math.min(dp[i-1][j+1],dp[i-1][j-1]),dp[i-1][j]) + matrix[i][j];
                }
            }
        }

        int result = 100*n+1;
        for(int i = 0; i < n; i++){
            result = Math.min(result,dp[n-1][i]);
        }

        return result;

    }
}