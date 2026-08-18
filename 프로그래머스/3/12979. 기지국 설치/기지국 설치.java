import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {

        int st = 1, cnt = 0;
        int arrow = w * 2 + 1;
        
        for(int i = 0; i < stations.length; i++){
            int end = stations[i] - w - 1;
            
            if(st <= end){
                int d = end - (st - 1);
                cnt += d / arrow + (d % arrow != 0 ? 1 : 0);                
            }
            
            st = stations[i] + w + 1;
            
        }
        
        if(st <= n){
            int d = n - st + 1;
            cnt += d / arrow + (d % arrow != 0 ? 1 : 0);
        }
        
        return cnt;
        
    }
}