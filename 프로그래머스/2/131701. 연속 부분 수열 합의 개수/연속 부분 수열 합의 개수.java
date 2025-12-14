import java.util.*;

class Solution {
    public int solution(int[] elements) {
        
        int n = elements.length;
        Set<Integer> set = new HashSet<>();
        
        for(int k = 1; k <= n; k++){
            for(int i = 0; i < n; i++){
                int cnt = 0;
                for(int j = i; j < i+k; j++){
                    cnt+=elements[j%n];
                }
                set.add(cnt);
            }
        }
        
        return set.size();
        
    }
}