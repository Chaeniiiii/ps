import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        
        Arrays.sort(targets,(a,b) -> a[1] - b[1]);
        
        int end = targets[0][1];
        int cnt = 1;
        
        for(int i = 1; i < targets.length; i++){
            
            int[] nxt = targets[i];
            if(end <= nxt[0]){
                end = nxt[1];
                cnt ++;
            }
            
        }
        
        return cnt;
        
    }
}