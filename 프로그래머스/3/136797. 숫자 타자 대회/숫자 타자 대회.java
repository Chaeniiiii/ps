import java.util.*;

class Solution {
    
    private static final int SIZE = 10;
    private static int[][] cost ;
    private static int[][][] dp;
    
    public int solution(String numbers) {
        
        cost = new int[SIZE][SIZE]; //i -> j로 가는 데 드는 최소 비용 저장 배열 
        init();
        
        dp = new int[numbers.length()][SIZE][SIZE];
        for(int i = 0; i < numbers.length(); i++){
            for(int j = 0; j < SIZE; j++){
                Arrays.fill(dp[i][j],-1);
            }
        }

        return calc(0,4,6,numbers);
    }
    
    private static int calc(int idx, int lt, int rt, String nums){
        
        if(idx == nums.length()){
            return 0;
        }
        
        if(dp[idx][lt][rt] != -1) return dp[idx][lt][rt];
        
        int n = nums.charAt(idx) - '0';
        int result = Integer.MAX_VALUE;
        
        //왼쪽 손가락을 움직이는 경우
        if(n != rt){
            result = Math.min(calc(idx+1,n,rt, nums)+cost[lt][n],result);
        }
        //오른쪽 손가락을 움직이는 경우
        if(n != lt){
            result = Math.min(calc(idx+1, lt, n, nums) + cost[rt][n],result);
        }
        
        return dp[idx][lt][rt] = result;
        
    }
    
    
    private static void init(){
        
        int r1, r2, c1, c2;
        
        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                if(i == j){
                    cost[i][j] = 1;
                    continue;
                }
                if(i == 0){
                    r1 = 3;
                    c1 = 1;
                }
                else{
                    r1 = (i - 1) / 3;
                    c1 = (i - 1) % 3; 
                }
                if(j == 0){
                    r2 = 3;
                    c2 = 1;
                }         
                else{
                    r2 = (j - 1) / 3;
                    c2 = (j - 1) % 3;
                }
                
                int dr = Math.abs(r1 - r2);
                int dc = Math.abs(c1 - c2);
                int min = Math.min(dr, dc);
                int max = Math.max(dr, dc);
                
                int dist = dr + dc;
                
                //상하좌우에 존재
                if(dist == 1){
                    cost[i][j] = 2;
                }
                else{
                    cost[i][j] = min * 3 + (max - min) * 2;
                }
                
            }
        }
        
    }
}