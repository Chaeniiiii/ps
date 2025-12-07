import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        
        int n = targets.length;
        
        Arrays.sort(targets,(a,b)->{
            if(a[1] == b[1]){
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        
        int st = 0, cnt = 0;
        for(int i = 0; i < n; i++){
            int[] now = targets[i];
            if(st <= now[0]){
                cnt++;
                st = now[1];
            }
        }
        
        return cnt;
        
    }
}