import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        
        int[] result = new int[n];
        int idx = 0, origin = n;
        long total = 1;
        k--;
        
        ArrayList<Integer> number = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            number.add(i);
            total *= i;
        }
        
        while(idx < origin){
            
            long unit = total / n;
            int p = (int)(k / unit);
            
            result[idx] = number.get(p);
            number.remove(p);
            
            total /= n;
            k %= unit;
            n--;
            idx++;
            
        }
        
        return result;
        
    }
}