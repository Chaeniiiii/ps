class Solution {
    
    private static final int MAX = 600001;
    private static final int MOD = 1000000007;
    
    public int solution(int n) {
        
        int [] dp = new int[MAX];
        
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i = 3; i<=n; i++){
            dp[i] = (dp[i-2] + dp[i-1]) % MOD;
        }

        return dp[n];
        
    }
    
}