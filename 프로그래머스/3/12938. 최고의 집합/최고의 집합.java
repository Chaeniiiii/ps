import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        
        if(n > s) return new int[]{-1};
        int idx = n;
        int[] result = new int[idx];                                                                      
        
        Arrays.fill(result, s/n);
        s %= n;
        if(s == 0) return result;
        
        for(int i = idx - 1; i >= idx - s; i--){
            result[i] ++;
        } 
        
        return result;
            
        
    }
}