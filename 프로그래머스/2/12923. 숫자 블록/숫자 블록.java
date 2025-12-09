import java.util.*;

class Solution {
    public int[] solution(long begin, long end) {
        
        int b = (int)begin;
        int e = (int)end;
        
        int[] result = new int[e-b+1];
        
        for(int i = b; i <= e; i++){
            
            result[i-b] = 1;
            
            for(int j = 2; j <= Math.sqrt(i); j++){
                if(i % j == 0){
                    int p = i / j; 
                    if(p > j && p < 10000001){
                        result[i-b] = p;
                        break;
                    }
                    else result[i-b] = j;
                }
            }
        }
        
        if(b == 1) result[0] = 0;
        return result;
        
    }
    
} 