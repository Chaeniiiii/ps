import java.util.*;

class Solution {
    public int solution(int[] elements) {
        
        int size = elements.length;
        Set<Integer> set = new HashSet<>();
        
        for(int i = 1; i <= size; i++){
            
            for(int lt = 0; lt < size; lt++){
                int cnt = 0;
                
                for(int k = lt; k < lt + i; k++){
                    cnt+=elements[k%size];
                }
                set.add(cnt);
            }
        }
        
        return set.size();
        
    }
}