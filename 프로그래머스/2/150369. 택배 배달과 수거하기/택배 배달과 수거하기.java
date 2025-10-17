import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        
        int d = 0, p = 0;
        long result = 0;
        for(int t = n-1; t >= 0; t --){
            
            d -= deliveries[t];
            p -= pickups[t];
            
            while(d < 0 || p < 0){
                d += cap;
                p += cap;
                
                result += (t + 1) * 2;
            }
        }
        
        return result;
        
    }
}