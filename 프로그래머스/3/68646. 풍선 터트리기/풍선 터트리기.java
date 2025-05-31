import java.util.*;

class Solution {
    public int solution(int[] a) {
        
        Set<Integer> set = new HashSet<>();
        
        int min = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        
        for(int i = 0; i<a.length; i++){
            min = Math.min(min,a[i]);
            min2 = Math.min(min2,a[a.length-1-i]);
            
            set.add(min);
            set.add(min2);
        }

        return set.size();
        
        
    }
}