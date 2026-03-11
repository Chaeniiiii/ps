import java.util.*;

class Solution {
    public int[] solution(long begin, long end) {
        
        int size = (int)(end - begin + 1);
        int[] result = new int[size];
        
        for(long i = begin; i <= end; i++){
            
            int idx = (int)(i - begin);
            int max = 1;
            
            for(int j = 2; j <= (int)Math.sqrt(i); j++){
                int pair;
                if(i % j == 0){
                    pair = (int)(i / j);
                    if(pair <= 10_000_000){
                        max = pair;
                        break;
                    }
                    else{
                        max = Math.max(max,j);
                    }
                }
            }
            
            result[idx] = max;
            
        }
        
        if(begin == 1) result[0] = 0;
        return result;
                
    }
}