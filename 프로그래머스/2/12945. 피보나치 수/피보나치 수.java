class Solution {
    
    private static final int MOD = 1234567;
    
    public int solution(int n) {
    
        int [] num = new int[n+1];
        num[1] = 1;
        
        for(int i = 2; i<=n; i++){
            num[i] = (num[i-1] + num[i-2])%MOD;
        }
        
        return num[n];
        
    }
     
}