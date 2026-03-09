import java.util.*;

class Solution {
    public int[] solution(long begin, long end) {

        int size = (int)(end - begin + 1); 
        int[] result = new int[size];
        
        Arrays.fill(result,1);
        result[0] = begin == 1 ? 0 : 1;
        
        for(long i = end; i >= begin; i--){
            
            int idx = (int)(i - begin);
            if(result[idx] > 1) continue;
            
            for(int j = 2; j <= (int)Math.sqrt(i); j++){
                int pair;
                if(i % j == 0){
                    pair = (int)(i / j);
                    if(pair <= 10_000_000){
                        result[idx] = pair;
                        break;
                    }
                    else result[idx] = Math.max(result[idx],j);
                }
            }
            
        }
        
        return result;
        
    }
}