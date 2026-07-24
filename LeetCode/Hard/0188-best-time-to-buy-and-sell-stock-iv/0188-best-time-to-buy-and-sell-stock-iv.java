class Solution {
    public int maxProfit(int k, int[] prices) {
        
        int[][][] dp = new int[k+1][prices.length][2];
        for(int i = 1; i <= k; i++){
            dp[i][0][0] = -prices[0];
        }

        for(int i = 1; i < prices.length; i++){
            for(int j = 1; j <= k; j++){
                dp[j][i][0] = Math.max(dp[j-1][i-1][1] - prices[i], dp[j][i-1][0]);
                dp[j][i][1] = Math.max(dp[j][i-1][0] + prices[i],dp[j][i-1][1]);
            }
        }

        return dp[k][prices.length-1][1];

    }
}