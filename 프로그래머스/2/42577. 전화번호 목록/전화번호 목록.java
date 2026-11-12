import java.util.*;

class Solution {
    public boolean solution(String[] pb) {
        
        Arrays.sort(pb, (a,b) -> a.compareTo(b));
        
        for(int i = 0; i < pb.length - 1; i++){
            String now = pb[i];
            String nxt = pb[i+1];
            
            if(nxt.startsWith(now)) return false;
        }
        
        return true;
        
    }
}