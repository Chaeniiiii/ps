import java.util.*;

class Solution {
    public int[] solution(long begin, long end) {
        
        int len = (int)(end - begin + 1);
        int[] result = new int[len];
        
        int idx = len - 1;
        for(long i = end; i >= Math.max(begin,2); i--){
            if(result[idx] > 1){
                idx--;
                continue;
            }
            
            long max = 1;
            for(int k = 2; k <= Math.ceil(Math.sqrt(i)); k++){
                if(i % k == 0){
                    long pair = i / k;
                    if(pair > 10_000_000) max = k;
                    else max = Math.max(max,pair);
                }
            }
            
            result[idx] = (int)max;
            idx--;
            
        }
        
        return result;
        
    }
}