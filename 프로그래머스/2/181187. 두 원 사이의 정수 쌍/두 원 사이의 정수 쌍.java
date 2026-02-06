import java.util.*;

class Solution {
    public long solution(long r1, long r2) {
        
        long result = 0;
        
        for(long x = 1; x <= r2; x++){
            long maxY = (long)Math.floor(Math.sqrt(r2 * r2 - x * x));
            long minY = 0;
            if(x < r1) minY = (long)Math.ceil(Math.sqrt(r1 * r1 - x * x));
            
            result += maxY - minY + 1;
            
        }
        
        return result * 4;
        
    }
}