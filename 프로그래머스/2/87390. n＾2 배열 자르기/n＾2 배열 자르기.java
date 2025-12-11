import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        
        int lt = (int)left;
        int rt = (int)right;
        
        int[] result = new int[rt-lt+1];
        for(long i = left; i <= right; i++){
            
            int p = (int)(i / n);
            int d = (int)(i % n);
            
            result[(int)(i-left)] = Math.max(p,d) + 1;
            
        }
        
        return result;
        
    }
}