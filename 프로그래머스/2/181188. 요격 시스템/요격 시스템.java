import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        
        Arrays.sort(targets, (a,b) -> {
            if(a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        
        int cnt = 0, st = 0;
        for(int i = 0; i < targets.length; i++){
            int[] tg = targets[i];
            if(st <= tg[0]){
                cnt++;
                st = tg[1];
            }
            else{
                st = Math.min(st,tg[1]);
            }
        }
        
        return cnt;
        
    }
}