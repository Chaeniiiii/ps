import java.util.*;

class Solution {
    public long solution(int k, int d) {
        
        long result = 0;
        
        for(long i = 0 ; i <= d; i+=k){
            long maxY = (long) Math.sqrt((long)d*d-(long)i*i);
            result += maxY / k + 1; 
        }
        
        return result ;
        
    }
}