import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        
        if(s < n) return new int[]{-1};
        
        int m = s / n;
        int d = s % n;
        
        int[] result = new int[n];
        Arrays.fill(result,m);
        
        for(int i = 0; i < d; i++){
            result[n - i - 1]++;
        }
        
        return result;
        
    }
}