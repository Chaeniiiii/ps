import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        
        int[] result = new int[n];
        int idx = 0;
        
        while(n > 1){
            
            if(s < n) return new int[]{-1};
            
            int mid = s / n;
            
            result[idx] = mid;
            s -= mid;
            idx++;
            n--;
            
        }

        result[idx] = s;
        return result;
        
    }
}