import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        
        int st = 1;
        int idx = 0;
        int inf = w * 2 + 1;
        int result = 0;
        
        while(st <= n){
            
            if(idx < stations.length && st >= stations[idx] - w){
                st = stations[idx] + w + 1;
                idx++;
            }
            else{
                result++;
                st += inf;
            }
            
        }
        
        return result;

    }
}