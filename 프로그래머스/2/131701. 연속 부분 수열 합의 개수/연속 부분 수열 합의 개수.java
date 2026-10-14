import java.util.*;

class Solution {
    public int solution(int[] elements) {
        
        int len = elements.length;
        Set<Integer> set = new HashSet<>();
        
        for(int i = 0; i < len; i++){
            int cnt = 0;
            for(int j = 0; j < len; j++){
                cnt += elements[(i+j) % len];
                set.add(cnt);
            }
        }
        
        return set.size();
        
    }
}