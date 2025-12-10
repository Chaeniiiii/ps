import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        
        int lt = (int)left;
        int rt = (int)right;
        
        int[] result = new int[rt -  lt + 1];
        for(long i = left; i <= right; i++){
            long q = i / n; 
            long d = i % n; 
            
            long st = q + 1; 
            long cnt = 0; 
            if(d >= st)  cnt = Math.abs(d - st) + 1;
            int idx = (int)(i - lt);
            result[idx] = (int)(st + cnt);
            
        }
        
        return result;
        
    }
}