import java.util.*;

class Solution {
    public int[] solution(long begin, long end) {
        
        int[] result = new int[(int)(end - begin + 1)];
        
        for(long i = begin; i <= end; i++){
            
            int idx = (int)(i - begin);
            result[idx] = 1;
            
            for(long k = 2; k <= (long)Math.sqrt(i); k++){
                if(i % k != 0) continue;
                int num = (int)(i/k);
                if(num > 10000000){
                    result[idx] = (int)k;
                }
                else{
                    result[idx] = num;
                    break;
                }
                
            }
            
        }
        
        if(begin == 1) result[0] = 0;
        return result;
        
    }
}