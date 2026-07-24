import java.util.*;

class Solution {
    public int maxProfit(int[] prices) {
        
        int buy1 = -prices[0];
        int buy2 = -prices[0];

        int sell1 = 0;
        int sell2 = 0;

        for(int i = 1; i < prices.length; i++){
            int p = prices[i];
            
            buy1 = Math.max(buy1, -p);
            sell1 = Math.max(sell1,buy1+p);

            buy2 = Math.max(sell1 - p, buy2);
            sell2 = Math.max(sell2,buy2+p);

        }

        return sell2;

    }
}