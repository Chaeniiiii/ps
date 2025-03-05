import java.util.*;

class Solution {
    public int solution(int[] elements) {
        
        int size = elements.length;
        
        Set<Integer> set = new HashSet<>();
        
        for(int lt = 0; lt<size; lt++){
            int arg = 1;
            while(arg <= size){
                
                int cnt = 0;
                for(int i = lt; i<lt+arg; i++) {
                    cnt +=elements[i%size];
                }
                set.add(cnt);
                arg ++;
            }
        }
        return set.size();
    }
}