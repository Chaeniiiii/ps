import java.util.*;

class Solution {
    
    public long[] solution(int n, long left, long right) {
        
        int len = (int)(right-left+1);
        long [] result = new long[len];
        
        int idx = 0;
        for(long i = left; i<=right; i++){
            
            long a = i/n;
            long b = i%n;

            result[idx] = Math.max(a,b)+1;
            idx++;
            
        }
        
        return result;
        
    }
}