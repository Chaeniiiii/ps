import java.util.*;

class Solution {

    public int coinChange(int[] coins, int amount) {

        int [] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;

        for(int i = 0; i<=amount; i++){
            for(int coin : coins){
                int next = i+coin;
                if(next > amount || next < 0) continue;
                dp[next] = Math.min(dp[next],dp[i]+1);
            }
        }

        return dp[amount] == amount+1 ? -1 : dp[amount];

    }
}