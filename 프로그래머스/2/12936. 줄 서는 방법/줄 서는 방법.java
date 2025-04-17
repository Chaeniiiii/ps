import java.util.*;

class Solution {
    
    private static long [] dp;
    
    public int[] solution(int n, long k) {
        
        ArrayList<Integer> arr = new ArrayList<>();
        int [] result = new int[n];
        
        dp = new long[n+1];
        dp[0] = dp[1] = 1;
        
        int num = n-1;
        
        for(int i = 1; i<=n; i++) arr.add(i);
        
        for(int i = 0; i<n; i++){
            
            int idx = 0;
            long f = getFactorial(num);
            
            if(f <= k){
                idx += (int)(k/f);
                if(k % f == 0) idx--;
            }
            
            if(idx >= arr.size()){
                result[i] = arr.get(0);
                break;
            }
            
            k-=(f*idx);
            result[i] = arr.get(idx);
            arr.remove(arr.get(idx));
            
            num--;

        }
        
        return result;
        
    }
    
    private static long getFactorial(int num){
        
        if(num == 0 || num == 1) return 1;
        if(dp[num] != 0) return dp[num]; 
        
        return dp[num] = num * getFactorial(num-1);
        
    }
}