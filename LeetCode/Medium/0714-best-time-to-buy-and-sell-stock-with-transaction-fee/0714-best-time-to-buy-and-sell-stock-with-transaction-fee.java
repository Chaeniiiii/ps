import java.util.*;

class Solution {
    public int maxProfit(int[] prices, int fee) {

        if(prices.length == 1) return 0;

        int buy = -prices[0];
        int sell = 0;

        for(int i = 1; i < prices.length; i++){
            int prevB = buy;
            int prevS = sell;

            buy = Math.max(prevS - prices[i],prevB);
            sell = Math.max(prevS, prevB + prices[i]-fee);
                
        }

        return sell;
            
    }
}