class Solution {
    public int maxProfit(int[] prices) {
        
        if(prices.length == 1) return 0;

        int buy = -prices[0]; //첫 날 주식을 산 경우
        int sell = 0; //첫 날 팔 수 없음 
        int cool = 0; //첫 날 아무것도 안 한 상태 

        for(int i = 1; i < prices.length; i++){
            int prevB = buy;
            int prevS = sell;
            int prevC = cool;

            buy = Math.max(prevB,prevC - prices[i]);
            sell = prevB + prices[i];
            cool = Math.max(prevS,prevC);

        }

        return Math.max(sell,cool);


    }
}