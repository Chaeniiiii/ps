import java.util.*;

class Solution {
    
    public int solution(int[] elements) {

        int n = elements.length;
        Set<Integer> set = new HashSet<>();
        
        for(int i = 0; i < n; i++){
            int cnt = 0;
            for(int j = i; j < n + i; j++){
                cnt += elements[j % n];
                set.add(cnt);
            }
        }
        
        return set.size();
    }
    
}