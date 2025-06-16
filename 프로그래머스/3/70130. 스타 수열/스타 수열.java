import java.util.*;

class Solution {
    public int solution(int[] a) {
        
        Set<Integer> set = new HashSet<>();
        
        int lt = 0, rt = 1;
        int len = 0;
        
        while(lt < a.length){
            
            if(a[lt] == a[rt]){
                lt += 2;
                rt += 2;
                continue;
            }
            
            System.out.printf("%d %d\n",lt,rt);
            
            if(set.isEmpty() || set.contains(a[lt]) || set.contains(a[rt])){
                
                len += 2;
                lt += 2;
                rt += 2;
                
                set.add(a[lt]);
                set.add(a[rt]);
            }
        }
            
        return len;
        
    }
}