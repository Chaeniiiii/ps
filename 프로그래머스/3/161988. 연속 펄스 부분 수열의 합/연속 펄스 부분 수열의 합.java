import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        
        boolean type = true;
        
        long result = 0;
        long result1 = 0;
        long result2 = 0;
        
        for(int num : sequence){
            
            result1 += type ? num : - num;
            result2 += type ? -num : num;
            
            result1 = Math.max(result1,0);
            result2 = Math.max(result2,0);
            
            result = Math.max(result,Math.max(result1,result2));
            type = !type;
        }
        
        return result;
        
    }
}