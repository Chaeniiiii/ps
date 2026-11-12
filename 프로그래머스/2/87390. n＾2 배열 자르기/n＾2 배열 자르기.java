import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        
        int size = (int)(right - left);
        int[] result = new int[size + 1];

        for(long i = left; i <= right; i++){
            long m = (i / n);
            long d = (i % n);
            
            result[(int)(i - left)] = (int)Math.max(m,d) + 1;
        }
        
        return result;
        
    }
}