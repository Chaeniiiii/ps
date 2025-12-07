import java.util.*;

class Solution {
    public long solution(int r1, int r2) {
        
        long result = 0;
        
        for(int i = 1; i <= r2; i++){
            long maxY = (long)Math.floor(Math.sqrt(Math.pow(r2,2) - Math.pow(i,2)));
            long minY = (long)Math.ceil(Math.sqrt(Math.pow(r1,2) - Math.pow(i,2)));
            
            result += (maxY - minY + 1);
        }
        
        return result * 4;
        
    }
}